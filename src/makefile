JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES=\
	Interpreter.java\
	Scanner/ScannerUtil.java\
	Scanner/Scanner.java\
	Scanner/TOKEN.java\
	Scanner/TokenItem.java\
	Parser/Expr.java\
	Parser/Factor.java\
	Parser/Out.java\
	Parser/Term.java

default: classes

classes: $(CLASSES:.java=.class)

all:  $(Classes)

clean:
	$(RM) *.class