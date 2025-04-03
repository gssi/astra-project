# ASTRA Project – Digital Twin Scheduler Tool

This repository contains the full implementation of the **ASTRA Scheduler Tool**, a Model-Driven Engineering (MDE)-based solution for designing, validating, and optimizing task schedules in safety-critical satellite systems. The tool supports Digital Twin-based runtime adaptation through scheduling reconfiguration and telemetry-driven monitoring.

## 📦 Project Structure

The repository is organized as a multi-module Maven project, composed of the following submodules:

### 1. `astra-project-editor`
A graphical editor used to design scheduling configurations based on the defined metamodel. It provides a visual concrete syntax for interacting with task attributes and execution constraints.

### 2. `astra-project-metaeditor`
Contains the configuration and resources needed to define the graphical editor. It includes model mappings, layout settings, and palette definitions for customizing the design interface.

### 3. `astra-project-metamodel`
Defines the Ecore-based metamodel representing the scheduling domain. It models tasks, dependencies, start/end constraints, and execution parameters used across the entire toolchain.

### 4. `astra-project-solver`
Implements the validation and optimization logic. It includes:
- `EVL_validation`: EVL (Epsilon Validation Language) rules for checking model constraints (e.g., CPU load threshold).
- Java utilities to validate instances, prepare optimization inputs, and trigger reconfiguration logic.

## 🚀 Running the Tool

To launch the graphical scheduling tool:

1. Open the project in your IDE (e.g., Eclipse or IntelliJ).
2. Navigate to the `astra-project-editor` module.
3. Run the `EditorAppMain.java` class as a **Standard Java Application**.

This will start the GUI for designing, editing, and validating scheduling configurations interactively.

## 🔧 Build Instructions

To compile all modules:

```bash
mvn clean install