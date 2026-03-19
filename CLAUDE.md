# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Coding Standards

Before generating any code in this repository, always consult the [doc/](doc/) directory first. Standards and conventions defined there take precedence over defaults. Currently:

- [doc/calc.md](doc/calc.md) — naming conventions, method design, error handling, I/O patterns, and instructions for adding new operations

## Build & Run

```bash
# Compile
javac Calculator.java

# Run
java Calculator
```

## Architecture

This is a single-file Java console application ([Calculator.java](Calculator.java)).

- All arithmetic operations are implemented as static methods (`add`, `subtract`, `multiply`, `divide`, `modulo`, `power`, `sqrt`)
- `main` drives an interactive REPL loop using `Scanner` on stdin
- Error handling covers: divide/modulo by zero, negative square root, and non-numeric input
