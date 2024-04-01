# Smelly virtual pet code refactoring kata

## Description

This our first week in a new company, we've been tasked to modify to the existing codebase. 
However, it's evident that our journey won't be without its challenges:

- The code lacks any form of testing.
- It has a lot of bad smells, making it hard to comprehend and maintain.
- There is no documentation or requirements outlining how the code works.

Despite these obstacles, this is what we have to do: 

- Introduce a new feature that handles the unfortunate dead of the virtual pet when any of its attributes goes below zero.

## Instructions

Guided by our principles as a good software engineers, we have plan:

1. Establish a safety net of tests: Either through unit tests or characterization tests.
2. Refactor the existing code: addressing its bad smells and enhancing its overall clarity, maintainability, and extensibility.
3. Introduce the new feature: handle the virtual pet's dead when any attribute falls below zero.

## How to start

- Clone the repository
- Remove the content of the refactored code and start from scratch.
```bash
 rm -rf refactored/src/main/kotlin/*
 rm -rf refactored/src/test/kotlin/*
```
- Have fun!!


## Tips & instructions

- Here a useful library for characterisation tests: [ApprovalTests](https://approvaltests.com/)
- The code is used widespread in production, please don't change its interface, neither the constructor nor the method's signature.
- Feel free to add new classes, methods, or any new code as needed.
- Throughout this process, adhere strictly to the principles of Test-Driven Development (TDD).

## Bad smells

Here are the code smells present in the provided code:

1. **High cyclomatic complexity**: The `interact` function contains nested `if` statements, which can lead to high cyclomatic complexity and make the code hard to understand and maintain.
2. **Duplication**: There's duplication of code within the `if` branches for handling different actions. Each branch repeats similar conditional checks and logic.
3. **Magic Numbers**: Arbitrary numbers like 20, 10, 30, etc., are used without clear explanations, making the code harder to understand.
4. **Mixed Responsibility**: The `interact` function is responsible for both processing actions and ensuring status values stay within valid ranges, violating the Single Responsibility Principle.
5. **Hardcoded Values**: Activity names like "twister", "chess", etc., are hardcoded and not easily modifiable. This can lead to maintenance issues if these values need to change in the future.
6. **Minimal Error Handling**: There's minimal error handling for invalid or unexpected inputs. The code does not handle cases where the action string does not contain two parts or if the action or activity is unknown.
8. **Long Function**: The `interact` function is doing too many things and could benefit from being split into smaller, more focused functions. This makes the code harder to read and maintain.

These code smells can lead to reduced code quality, increased likelihood of bugs, and difficulties in future modifications and maintenance.
