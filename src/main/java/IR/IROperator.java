package IR;

public enum IROperator {
  Assign, VariableDeclaration, LazyExecutionStart, LazyExecutionEnd,
  AddExpr, SubExpr,
  MulExpr, DivExpr, AndExpr, OrExpr, XorExpr, NoOperation,
  ModExpr,EqualExpr,NotEqualExpr,
  LessThanExpr, GreaterThanExpr,LessEqualThanExpr,GreaterEqualThanExpr,
  CallExpr, BuildList,
  JumpIfNotTrue,
  Jump,
  Break, Continue,
}