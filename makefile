# Répertoires
SRC_DIR = src
BIN_DIR = bin

# Trouver tous les fichiers .java
SOURCES = $(shell find $(SRC_DIR) -name "*.java")
CLASSES = $(SOURCES:$(SRC_DIR)/%.java=$(BIN_DIR)/%.class)

# Cible par défaut : Compilation
all: compile

# Compilation
compile:
	@echo "Compilation des fichiers Java..."
	mkdir -p $(BIN_DIR)
	javac -d $(BIN_DIR) $(SOURCES) || (@echo "Erreur de compilation !" && exit 1)
	@echo "Compilation terminée."

# Exécuter Test
test: compile
	@echo "Exécution de la classe Test..."
	java -cp $(BIN_DIR) Test

# Exécuter le programme principal
run: compile
	@echo "Exécution du jeu..."
	java -cp $(BIN_DIR) BatailleNavale

# Nettoyage
clean:
	@echo "Nettoyage des fichiers compilés..."
	rm -rf $(BIN_DIR)/*.class
	@echo "Nettoyage terminé."

# Aide
help:
	@echo "Utilisation :"
	@echo "  make           Compile."
	@echo "  make test      Compile et exécute la classe Test"
	@echo "  make run       Compile et exécute le programme batailleNavale.Main."
	@echo "  make clean     Supprime les fichiers compilés."
	@echo "  make help      Affiche ce message d'aide."