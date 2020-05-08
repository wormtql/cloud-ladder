package AST;

import IR.BuildListIR;

import java.util.ArrayList;
import java.util.List;

public class RangeListInitializer extends ExpressionNode {
  public ExpressionNode start;
  public ExpressionNode end;
  public boolean exclusiveEnd;

  @Override
  public ExpressionNode reduce() {
    ExpressionNode _start = start.gen();
    ExpressionNode _end = end.gen();
    Temp t = new Temp();
    ir.emit(new BuildListIR(t, _start, _end));
    return t;
  }

  @Override
  public ExpressionNode gen() {
    return reduce();
  }

  @Override
  public ExpressionNode gen(int before, int after) {
    return gen();
  }

  @Override
  public List<Node> getChildren() {
    return new ArrayList<Node>() {{
      add(start);
      add(end);
    }};
  }
}

