# Smelly virtual pet code refactoring kata

## Description

This is our first week at a new company, and we've been tasked with modifying the existing codebase. 
However, it's evident that our journey will not be without challenges:

- The code lacks any form of testing.
- It has a lot of bad smells, making it hard to comprehend and maintain.
- There is no documentation or requirements outlining how the code works.

Despite these obstacles, this is what we have to do: 

- Introduce a new simple feature, to walk our virtual pet.

## Instructions

Guided by our principles as a good software engineers, we have plan:

1. Establish a safety net of tests: Either through unit tests or characterization tests.
2. Refactor the existing code: addressing its bad smells and enhancing its overall clarity, maintainability, and extensibility.
3. Introduce the new feature: walk the pet, but it will go with time ```walk 5```, each minute will increase by 2 happiness and hunger and decrease energy by 2.

## Tips & instructions

- Here a useful library for characterisation tests: [ApprovalTests](https://approvaltests.com/)
- The code is used widespread in production, please don't change its interface, neither the way it is constructed nor the public method's signature.
- Feel free to add new classes, default params, methods, or any new code as needed.
- Throughout this process, adhere strictly to the principles of Test-Driven Development (TDD).
- Remember to commit your changes frequently.

## How to start

- Clone the repository
- Remove the content of the refactored code and start from scratch.
```bash
 rm -rf refactored/src/main/kotlin/*
 rm -rf refactored/src/test/kotlin/*
```
- Have fun!!