# Encrypto-Pass

Constantly forgetting your passwords, tired of coming up with new ones every time your organisation / accunt requires a change? If so then this is the applcation for you. Encrypto-pass is a simle, secure and easy to use desktop application that encrypts and stores all your passwords locally, meanng no threat from nasty data breaches or insecure servers. Just open the applcation and start saving passwords today and password management will be a thing of the past

## Depenencies

- [Java Runtime Environment](https://openjdk.java.net/projects/jdk/11/)
- [Java 11](https://openjdk.java.net/projects/jdk/11/) -- development only
- Any text ide (Intellij recommended) -- development only
- [Gradle](https://gradle.org/) -- optional

## Installation

### Production

- Build the jar using ./gradlew buildJar command (Work pending for this).
- Run the created jar to install and launch the application.

### Development

- Pull this repository to your local machine
- Run ./gradlew build
- Run ./gradlew run

## Technologies

- Java 11
- [Java-Fx](https://openjfx.io/)

## Testing

This project uses the Junit framework, which will be automatically downloaded when the project builds. Torun the test cases simply run command `gradlew build` or `gradlew test`. To run a test file / case individually use your ide. Coverage Is handled by [jacoco](https://www.eclemma.org/jacoco/) and can be checked by running the `gradlew jacocoTestReport` command.

## Security

This applciation uses the [oswap security plugin](https://owasp.org/www-project-dependency-check/) to cehck for dependency vulnerablities, to run the report simply enter command `gradlew dependencyCheckAnalyze`. You can then read the report in the displayed location. Ensure that any generated keys are **not** commited, this will not compromise user information but is bad practice and may threatern any data you encrypt / store with the applcation.

## Usage

Upon running the application you will see the startup screen while background / startup process are running. Once these are complete you will see the main window with your accounts and passwords displayed. On first time use you will see the installation guide whch will create the required files / directories for use.

## Troubleshooting 

If you find any bugs or encounter any issues with the applciation please raise a bug / ticket within this repository in the *issues* tab. To make your issue easier to diagnose / fix post with the following:

- **System information**: Operating system, java version etc.
- **Reproduction steps**: How to replicate the issue.
- **Screenshots**: If possible detailing the error / problem you see.

## Contributing

As this project is open source feel free to contribute by reviewing pull requests, or creating a fork / branch (ask me for permissions). If you have any suggestions for features or functionality please raise them in the issues tab an I will have a look at them. Any Developers must adhere to the [style guide](https://google.github.io/styleguide/javaguide.html) and follow [TDD](https://en.wikipedia.org/wiki/Test-driven_development#:~:text=Test%2Ddriven%20development%20(TDD),so%20that%20the%20tests%20pass.) during development.

## Contributors

- [Jack Branch](https://github.com/pliantmeerkat) 
- [Aneesa Zafri](https://github.com/neesafarza)
