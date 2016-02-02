package relay;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java_cup.runtime.ComplexSymbolFactory;
import relay.backends.core.Backend;
import relay.backends.lwjgl.core.LWJGLBackend;
import relay.exceptions.RelayException;
import relay.layout.LayoutDefinition;
import relay.nodes.RootNode;
import relay.parser.Lexer;
import relay.parser.RelayParser;
import relay.parser.symbols.RelaySymbol;
import relay.symbolTable.SymbolTable;
import relay.symbolTable.SymbolTableBuilder;
import relay.tools.TreeVisualiser;

public class UILoader {
	public static Window buildUIFromFile(File source, String windowTitle) throws RelayException {
		Backend defaultBackend = LWJGLBackend.create();
		
		// Set up the parsing process
		ComplexSymbolFactory factory = new ComplexSymbolFactory();
		Lexer lexer;
		try {
			lexer = new Lexer(new FileReader(source), factory);
			relay.parser.RelayParser parser = new RelayParser(lexer, factory);

			// Parse the document, get a representative AST
			RelaySymbol root = (RelaySymbol)parser.parse().value;
			RootNode rootNode = (RootNode) root.compact();

			// Extract relevant information from the document
			SymbolTable symbolTable = SymbolTableBuilder.buildSymbolTable(rootNode);
			
			//new TreeVisualiser(rootNode);
			LayoutDefinition layout = LayoutDefinition.createFromParseTree(rootNode, symbolTable);
			return defaultBackend.createWindow(layout, windowTitle);
		
		} catch (FileNotFoundException exception) {
			throw new RelayException("UI source file was not found at " + source, exception);
		} catch (RelayException exception) {
			throw exception;
		} catch (Exception exception) {
			throw new RelayException(exception);
		}
		
		
	}
}
