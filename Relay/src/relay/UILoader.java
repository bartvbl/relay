package relay;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import java_cup.runtime.ComplexSymbolFactory;
import lib.geom.IndexRectangle2D;
import relay.backends.core.Backend;
import relay.backends.lwjgl.core.LWJGLBackend;
import relay.blockLinking.BlockLinker;
import relay.exceptions.RelayException;
import relay.layout.LayoutDefinition;
import relay.layout.LayoutDefinitionBuilder;
import relay.layout.MutableDependentValue;
import relay.nodes.RootNode;
import relay.parser.Lexer;
import relay.parser.RelayParser;
import relay.parser.symbols.RelaySymbol;
import relay.parser.symbols.RootSymbol;
import relay.symbolTable.SymbolTableBuilder;

public class UILoader {
	public static Window buildUIFromFile(File source, String windowTitle, IndexRectangle2D windowDimensions) throws RelayException {
		
		Backend defaultBackend = LWJGLBackend.create();
		defaultBackend.init();
		
		
		// Set up the parsing process
		ComplexSymbolFactory factory = new ComplexSymbolFactory();
		Lexer lexer;
		try {
			lexer = new Lexer(new FileReader(source), factory);
			relay.parser.RelayParser parser = new RelayParser(lexer, factory);

			// Parse the document, get a representative AST
			RelaySymbol root = (RelaySymbol)parser.parse().value;
			RootNode rootNode = (RootNode) ((RootSymbol) root).compactRoot(windowDimensions);

			// Extract relevant information from the document
			SymbolTableBuilder.createLocalSymbolTables(rootNode);
			
			// Perform the linking phase: figure out which expressions depend on which other values
			MutableDependentValue[] linkedValues = BlockLinker.linkBlockExpressions(rootNode);
			
			System.out.println("Linked " + linkedValues.length + " values.");
			
			//new TreeVisualiser(rootNode);
			LayoutDefinition layout = LayoutDefinitionBuilder.createFromParseTree(rootNode, linkedValues);
			return defaultBackend.createWindow(layout, windowTitle, windowDimensions);
		
		} catch (FileNotFoundException exception) {
			throw new RelayException("UI source file was not found at " + source, exception);
		} catch (RelayException exception) {
			throw exception;
		} catch (Exception exception) {
			throw new RelayException(exception);
		}
		
		
	}
}
