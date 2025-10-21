# Compiler
JAVAC = javac

# Source and build directories
SRC_DIR = src/main/java
BUILD_DIR = build

# Package and class name
PACKAGE = codewarts
CLASS = SortingHat

# Path to the Java source file
SRC = $(SRC_DIR)/$(PACKAGE)/$(CLASS).java

# Target .class file path
CLASS_FILE = $(BUILD_DIR)/$(PACKAGE)/$(CLASS).class

# Default target
all: $(CLASS_FILE)

# Rule to compile the specific Java file
$(BUILD_DIR)/$(PACKAGE)/%.class: $(SRC_DIR)/$(PACKAGE)/%.java
	@mkdir -p $(dir $@)
	$(JAVAC) -d $(BUILD_DIR) $<

# Clean build output
clean:
	rm -rf $(BUILD_DIR)

# Run the program
run: all
	java -cp $(BUILD_DIR) $(PACKAGE).$(CLASS)
