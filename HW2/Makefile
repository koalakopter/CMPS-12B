#------------------------------------------------------------------------------
# A Makefile with macros
#------------------------------------------------------------------------------

JAVASRC    = ChessBoard.java Node.java Chesspiece.java LinkedList.java King.java Queen.java Rook.java Bishop.java Knight.java Pawn.java
SOURCES    = README Makefile $(JAVASRC)
MAINCLASS  = ChessBoard
CLASSES    = ChessBoard.class Node.class Chesspiece.class LinkedList.class King.class Queen.class Rook.class Bishop.class Knight.class Pawn.class
JARFILE    = ChessBoard.jar

all: $(JARFILE)

$(JARFILE): $(CLASSES)
	echo Main-class: $(MAINCLASS) > Manifest
	jar cvfm $(JARFILE) Manifest $(CLASSES)
	rm Manifest

$(CLASSES): $(JAVASRC)
	javac -Xlint $(JAVASRC)

clean:
	rm $(CLASSES) $(JARFILE)
