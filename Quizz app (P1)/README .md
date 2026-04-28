# Java Quiz Application (Console)

This project is a console-based Java quiz app built while learning Java from basics to advanced concepts.

## What's now more advanced

- Uses a **question bank** with metadata (category + difficulty).
- Randomizes quiz order using `Collections.shuffle(...)`.
- Validates input and only accepts `a`, `b`, `c`, or `d`.
- Calculates score, percentage, and pass/fail status.
- Shows a **detailed review** after the quiz with per-question correctness.
- Organizes logic into clear classes (`Main`, `Question`, `QuestionService`).

## How to run

```bash
cd "Quizz app (P1)"
javac Main.java Question.java QuestionService.java
java Main
```
