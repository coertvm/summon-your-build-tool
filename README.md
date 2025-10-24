# Summon your build tool

## Introduction

Many new Java developers feel like first-years at Codewarts, nervously waiting for the Sorting Hat
to decide their fate - the choice is between Maven or Gradle (or Ant :-P). In this hands-on tech
talk, we'll guide you through the "sorting ceremony" of Java build tools, helping you understand
their strengths, quirks and ideal use cases so you can confidently wear the hat that fits your
project.

## The Fellowship of the Build

Before we dive into our magical world of Java builds, let's hear from a brave traveler who's
journeyed here from another realm - the land of .NET. Like a hobbit stepping into Codewarts, he's
faced strange incantations and ancient POM scrolls. Please welcome him as he shares his quest
through [The Fellowship of the Build](docs/the-fellowship-of-the-build.md).

## Ready?

You are ready if you have [Git](https://git-scm.com/) for Windows (Git Bash) and a
[JDK](https://jdk.java.net/) installed. Or are otherwise running on Linux or a Mac (in other words
are using [Bash](https://www.gnu.org/software/bash/bash.html)). We'll show you how to install the
build tools. Ensure the `JAVA_HOME` environment variable is set to your JDK folder.

## A Peek under the Hat

Let's take a quick peek under the Sorting Hat:

- [SortingHat.java](src/main/java/codewarts/SortingHat.java)
- [SortingHatTest.java](src/test/java/codewarts/SortingHatTest.java)
- [MadHatter.java](src/main/java/codewarts/MadHatter.java)

## Backstory

- 1990s
  - Make & Ant. Early Java projects often used Unix Make, then Apache Ant (1999) emerged, using XML
    to define build steps.
- 2000s
  - Apache Ivy was introduced around 2004 as a dependency management system for Apache Ant.
  - Apache Maven (2004) replaced Ant's manual scripts with a convention-over-configuration model
    and centralized dependency management.
- 2010s
  - Gradle (2007, popularized in the 2010s) combined Ant's flexibility and Maven's conventions,
    using a Groovy/Kotlin DSL for scripting.
- 2020s
  - Tools like Bazel and Buck emerged for large-scale builds, while Gradle remains dominant for
    most Java projects.

## Javador

**Tool:** JDK\
**Values:** Self-reliance, understanding, courage\
**Motto:** *"True mastery needs no wand - only will."*

Coders of Javador are the old souls of the Java world - methodical, disciplined and unafraid to
get their hands dirty with javac and jar commands. They can summon .class files from thin air
using nothing but a terminal.

The JDK includes basic build tools like javac (compiler), jar (package tool) and javadoc
(documentation generator). These are low-level tools that handle individual tasks, but require
manual scripting or external tools to manage build workflows.

```plaintext
project-root/
├── <build directory>/
└── <source files>
```

```
javac -d <build directory> <source files>
java -cp <class path> <application>
```

* Build: `javac -d build src/main/java/codewarts/SortingHat.java`
* Run: `java -cp build codewarts.SortingHat`
* Clean: `rm -rf build`

## Makeclaw

**Tool**: GNU Make\
**Values**: Tradition, craftsmanship, simplicity\
**Motto**: *"One target at a time."*

Makeclaw coders respect the old ways - concise scripts, manual mastery and control over every rule.
Their Makefiles are like spell scrolls: cryptic, but powerful.

Make is a classic tool that uses Makefiles to define how to build and manage projects in C/C++. It
relies on rules with targets, dependencies and commands, and uses timestamps to determine what
needs rebuilding.

- Installation
  - If you are on Windows go to
    [ezwinports](https://sourceforge.net/projects/ezwinports/files/),
    - download `make-4.4.1-without-guile-w32-bin.zip`,
    - extract and copy `make.exe` to the project root.
  - Verify: `./make --version`

```plaintext
project-root/
├── <build directory>/
├── <source files>
└── Makefile
```

- Edit [`Makefile`](Makefile).

```
make [target]
```

* Clean: `./make clean`
* Build: `./make`
* Run: `./make run`

## Antforge

**Tool**: Apache Ant\
**Values**: Structure, persistence and XML sorcery\
**Motto**: *"No build too big, no tag too tangled."*

Antforgers believe in clarity and order. They trust in XML incantations to keep chaos at bay -
though their build files sometimes grow into ancient grimoires.

Apache Ant uses XML files to define tasks like compiling code, copying files and creating JARs.
It is procedural, meaning you explicitly list the steps to perform in a specific order. Concepts in
Ant are projects, targets (groups of tasks) and tasks (individual operations). Ant requires more
setup compared to newer tools.

- Installation
  - Go to [Apache Ant](https://ant.apache.org/), download and extract the downloaded file.
  - Set the environment variables:
    - `ANT_HOME` to the extracted file location.
    - Add `$ANT_HOME/bin` to `PATH`.
  - Go to [Apache Ivy](https://ant.apache.org/ivy/), download, extract, locate the JAR file and
    copy it into your Ant installation:
    - `cp ivy-<version>.jar $ANT_HOME/lib/`
  - Verify: `ant -version`

```plaintext
project-root/
├── <build directory>/
├── <dependency download directory>/
├── <source files>
├── build.xml
└── ivy.xml
```

- Edit [`build.xml`](build.xml) and [`ivy.xml`](ivy.xml).

```
ant [target]
```

* Clean: `ant clean`
* Build: `ant build`
* Run: `ant run`

## Mavenmere

**Tool**: Apache Maven\
**Values**: Convention, knowledge, dependency mastery\
**Motto**: *"By the power of POM."*

The Mavenmeres channel the strength of repositories and artifacts. They build with a single command
and trust the magic of convention over configuration.

Apache Maven uses an XML file to describe a project's structure, dependencies and build lifecycle.
It follows a convention-over-configuration approach, using a standardized directory layout and
predefined build phases (like compile, test and package). Maven builds follow a lifecycle, which is
made up of phases, and each phase consists of one or more goals. Maven handles dependency
management through repositories, making it popular for consistent builds across teams and projects.
Dependencies are not stored inside the project folder, they are downloaded and cached in a local
repository on your machine, so they can be reused across multiple projects.

- Installation
  - Go to [Apache Maven](https://maven.apache.org/), download and extract the downloaded file.
  - Add the `bin` folder of the extracted Maven installation to the `PATH` environment variable.
  - Verify: `mvn -version`

```plaintext
project-root/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── <source files>
│   └── test/
│       └── java/
│           └── <test files>
├── target/
└── pom.xml
```

- Edit [`pom.xml`](pom.xml).

```
mvn [<goal(s)>] [<phase(s)>]
```

* Clean: `mvn clean`
* Build: `mvn compile`
* Test: `mvn test`
* Run: `mvn exec:java`

### Hexes and Hiccups

- Dependency management: conflicts, scope confusion, snapshot vs. release confusion
- Slow builds
- Complex plugin configurations
- Project structure & POM complexity
  - Large, multi-module projects can have complicated hierarchies which become hard to maintain.
  - Misuse of parent POMs can cause confusing dependency or plugin management issues.
- Unclear error messages

### Charms and Cheats

- Dependency management: use `mvn dependency:tree` and `mvn dependency:analyze` goals.
- Slow builds
  - Use offline mode (-o) when you don't need to download new dependencies.
  - Use parallel builds (-T) for multi-module projects.
- Plugins
  - Read plugin documentation carefully.
  - Use plugin versions explicitly to avoid unexpected behavior from upgrades.
- Multi-module projects
  - Keep POMs clean, minimize inheritance.
  - Clearly define modules and use `dependencyManagement` for consistent versions.
  - Use `mvn help:effective-pom` to show the resolved POM after inheritance.
- Debugging
  - Use -X for debug logging to get more detailed error info.
  - Regularly run `mvn clean` to avoid stale artifacts causing weird issues.

### Spellbinding Scenarios

Maven shines in environments where standardization, repeatability and dependency management are
key: enterprise Java projects, multi-module (monorepo) projects, open source libraries and
frameworks, CI/CD pipelines and automated builds, dependency-heavy projects and legacy Java
projects.

Maven is not the best choice for: custom build logic or scripting, rapid prototyping with minimal
setup and projects that need incremental builds & caching optimization.

## Conjuring with Maven

1. Generate a new Maven project using archetype plugin:

```
cd ~
mvn archetype:generate -DgroupId=com.example.magic \
    -DartifactId=spell-demo \
    -DarchetypeArtifactId=maven-archetype-quickstart \
    -DinteractiveMode=false
```

2. Build it:

```
cd spell-demo/
mvn clean package
```

## Gradlewraith

**Tool**: Gradle\
**Values**: Modernity, flexibility, automation\
**Motto**: *"Build fast, script freely."*

Gradlewraiths combine the best of magic and scripting. They weave Groovy and Kotlin spells to
automate everything and summon productivity from thin air.

Gradle is a modern build automation tool for Java and other languages that uses a declarative DSL
(Groovy or Kotlin) to define builds. It combines the flexibility of Ant with Maven's dependency
management and follows a task-based model with a focus on incremental builds and performance.
Gradle is highly customizable and supports both convention and configuration, making it popular for
complex and scalable projects.

- Installation
  - Go to [Gradle](https://gradle.org/), download and extract the downloaded file.
  - Add the `bin` folder of the extracted Gradle installation to the `PATH` environment variable.
  - Verify: `gradle -v`.

```plaintext
project-root/
├── build/
├── gradle/libs.versions.toml  # (Optional) Version catalog
├── src/                       # Follows Maven conventions
├── build.gradle               # Main build script (Groovy or Kotlin DSL)
├── settings.gradle            # (Optional) Defines project name and subprojects
└── gradle.properties          # (Optional) Project settings or environment configs
```

- Edit [`build.gradle`](build.gradle).

```
gradle <task>
```

* Clean: `gradle clean`
* Build: `gradle compileJava` or `gradle build`
* Test: `gradle test`
* Run: `gradle run`

### Hexes and Hiccups

- Slow build times: not leveraging the Gradle Daemon or build cache.
- Dependency conflicts: between different versions of libraries.
- Complex build scripts
- Plugins not compatible with Gradle version.
- Debugging:
  - Cryptic error messages
  - Difficult to trace task or configuration that caused failure.

### Charms and Cheats

- Use the Gradle Daemon.
- Enable build cache.
- Leverage incremental builds.
- Use the Kotlin DSL for better IDE support and type safety.
- Run with `--scan` for build scan.
- Use `gradle dependencies` and `gradle dependencyInsight`.

### Spellbinding Scenarios

Gradle is at its best in complex, modular and performance-sensitive builds - especially when you
need flexibility or extensibility: large multi-module projects, Android development, polyglot /
multi-language builds, continuous integration and build automation and highly custom or
domain-specific build logic.

Gradle performs poorly or isn't ideal for: simple projects, projects requiring deterministic or
"locked down" builds and teams without build engineering expertise.

## Crafting with Gradle

1. Generate a new Gradle project:

```
cd ~
mkdir spell-demo
cd spell-demo
gradle init --dsl groovy \
    --type java-application \
    --package com.example.magic \
    --project-name spell-demo \
    --test-framework junit-jupiter \
    --no-split-project \
    --use-defaults
```

2. Build it:

```
gradle build
```

## Spells Yet to Master

Even the most skilled wizards have charms left to learn. Beyond building, packaging and testing,
there are deeper enchantments in the world of build tools: continuous integration and automation,
plugins, multi-module projects, configuration and customization, performance, deployment and
distribution, IDE integration, and security.

## There and Back Again

Our adventurer survived the journey - from the forests of Maven to the towers of Gradle - and lived
to tell the tale. We turn to the reflections of one who's been
[There and Back Again](docs/there-and-back-again.md) to hear his hard-won lessons and insights.

## The Council of Wizards

As our journey through the magical realms of Java build tools comes to a close, it's time to gather
as a council of wizards - sharing wisdom, answering questions and conjuring clarity. Step forward
and let your curiosities be heard!