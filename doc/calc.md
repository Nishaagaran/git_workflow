# Calculator — Coding Standards

## Naming Conventions

| Element | Convention | Example |
|---------|-----------|---------|
| Class | `PascalCase` | `Calculator` |
| Method | `camelCase` | `add`, `sqrt`, `divide` |
| Variable | `camelCase` | `result`, `choice` |
| Parameter | `camelCase`, single-letter for math operands | `a`, `b`, `base`, `exp` |

## Method Design

- Operation methods are **pure static functions** — they take inputs and return a result with no side effects.
- Each method performs **one operation only**. Do not combine logic across operations.
- Guard clauses are placed **at the top** of the method before any computation.

```java
// Correct — guard first, then logic
static double divide(double a, double b) {
    if (b == 0) throw new ArithmeticException("Cannot divide by zero");
    return a / b;
}
```

- Single-line methods use **inline body style** (no braces on separate lines):

```java
static double add(double a, double b) { return a + b; }
```

- Multi-line methods use **standard K&R brace style**.

## Error Handling

- Domain errors (bad input to a math operation) throw `ArithmeticException` with a descriptive message.
- User input parsing errors (`NumberFormatException`) are caught in `main` and reported without crashing the loop.
- Exceptions are **never swallowed silently** — always print `e.getMessage()` or a descriptive fallback.

```java
} catch (ArithmeticException e) {
    System.out.println("Math error: " + e.getMessage());
}
```

## Input / Output

- All user prompts use `System.out.print` (no newline) so input appears on the same line.
- Results are formatted to **4 decimal places** using `printf`:

```java
System.out.printf("%.4f %s %.4f = %.4f%n", a, op, b, result);
```

- Use `scanner.nextLine().trim()` for all input reads to handle leading/trailing whitespace.
- `Scanner` must be closed with `scanner.close()` when the program exits.

## Adding a New Operation

1. Add a static method following the existing signature pattern:

```java
static double myOp(double a, double b) {
    // guard clauses first
    return /* result */;
}
```

2. Add a menu entry in `main` with a consistent label format:

```
  N. OperationName  (symbol)
```

3. Handle it in the `switch` block (two-operand) or as a separate `if` branch (one-operand, like `sqrt`).
4. Update the valid range check (`choice >= 1 && choice <= N`) to include the new case number.
