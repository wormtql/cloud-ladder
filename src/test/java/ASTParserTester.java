import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileInputStream;
import java.io.InputStream;

public class ASTParserTester {
  public static void main(String[] args) throws Exception{
    String inputFile = null;
    if (args.length>0) inputFile = args[0];
    InputStream is = System.in;
    if(inputFile!=null) is = new FileInputStream(inputFile);
    ANTLRInputStream input = new ANTLRInputStream(is);
    CLParserLexer lexer = new CLParserLexer(input);
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    CLParserParser parser = new CLParserParser(tokens);
    ParseTree tree = parser.program();

    ASTParser trans = new ASTParser();
    Program p = (Program) trans.visit(tree);
    AST2IR ast2IR = new AST2IR();
    ASTWalker walker = new ASTWalker();
    walker.walk(ast2IR, p);
    Gson g = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
    System.out.println(g.toJson(ast2IR));
  }
}
