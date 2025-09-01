# Quiz Backend

This is a spring boot backend application build with kotlin for a quiz system

## Prerequisites

Before you begin, ensure you have the following installed:

- **Java 21**: The project uses Java 21, specified in the Gradle build file.
- **Gradle**: The project uses Gradle as the build tool. You can use the included Gradle Wrapper (`gradlew`).
- **Git**: To clone the repository (optional).

## Setup

1. **Clone the Repository** (if applicable):

in gitbash

Repository link:https://bitbucket.org/react-kotlin/backend/src/master/
git clone <repository-url> <---- without the <>'s

2. **Verify Java Version**: Ensure Java 21 is installed and configured. Run the following command to check in cmd

   java -version

   The output should include `21` for example (`openjdk 21.0.2`)

## Building the Project

To build the project, use the Gradle Wrapper:

```gitbash/cmd/Windows PowerSHell
./gradlew build
```

This command:

- Downloads dependencies specified in `build.gradle.kts`.
- Compiles the Kotlin source code.
- Runs tests (if any).
- Generates a JAR file in the `build/libs` directory.

If you want to skip tests during the build:

```gitbash/cmd/Windows PowerSHell
./gradlew build -x test
```

## Running the Application

To run the application locally:

```gitbash/cmd/Windows PowerSHell
./gradlew bootRun
```

This command:

- Starts the Spring Boot application.
- Runs the server on `http://localhost:8080` (it uses the default port,which is 8080).

### Notes !!!!!!! IMPROTANT !!!!!!!

- The application currently excludes database configuration (`DataSourceAutoConfiguration`) to avoid requiring a database. If you add database support (e.g., PostgreSQL) later, configure it in `src/main/resources/application.properties` and remove the exclusion in `Application.kt`.
- To run with debug logging for troubleshooting:

  ```gitbash/cmd/Windows PowerSHell
  ./gradlew bootRun --args='--debug'
  ```


## Future Database Setup

To enable chose DB (e.g-MySQL,PostgreSQL,H2...) (included as a runtime dependency):

1. Create a database.
2. Add the necessary db properties to `src/main/resources/application.properties`
3. Remove `exclude = [DataSourceAutoConfiguration::class]` from `Application.kt`.
4. Restart the application with `./gradlew bootRun`.
````