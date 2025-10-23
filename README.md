# Summon your build tool

## Intro

Many new Java developers feel like first-years at Codewarts, nervously waiting for the Sorting Hat
to decide their fate - the choice is between Maven or Gradle (or Ant :-P). In this hands-on tech
talk, we'll guide you through the "sorting ceremony" of Java build tools, helping you understand
their strengths, quirks and ideal use cases so you can confidently wear the hat that fits your
project.

## The Fellowship of the Build

Before we dive too deep into our magical world of Java builds, let's hear from a brave traveler
who's journeyed here from another realm - the land of .NET. Like a hobbit stepping into Codewarts,
he's faced strange incantations and ancient POM scrolls. Please welcome our guest as he shares his
quest through The Fellowship of the Build.

## Ready?

You are ready if you have Git for Windows (Git Bash) and a JDK installed. Or are otherwise running
on Linux or a Mac. We'll show you how to install the build tools. Ensure the `JAVA_HOME`
environment variable is set to your JDK folder.

## Peeking under the Hat

Let's take a quick peek under the Sorting Hat - our demo program that will guide us through the
journey ahead.

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
  - If you are on Windows and don't have Make installed, go to
    [ezwinports](https://sourceforge.net/projects/ezwinports/files/)
    - download `make-4.4.1-without-guile-w32-bin.zip`
    - extract and copy `make.exe` to the project root.

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

* Build: `./make`
* Run: `./make run`
* Clean: `./make clean`

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

* Build: `ant`
* Run: `ant run`
* Clean: `ant clean`

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

* Build: `mvn compile`
* Test: `mvn test`
* Run: `mvn exec:java`
* Clean: `mvn clean`

Hexes and Hiccups
Charms and Cheats

## Conjuring with Maven

## Gradlewraith

**Tool**: Gradle\
**Values**: Modernity, flexibility, automation\
**Motto**: *"Build fast, script freely."*

Gradlewraiths combine the best of magic and scripting. They weave Groovy and Kotlin spells to
automate everything and summon productivity from thin air.

Gradle is a modern build automation tool for Java and other languages that uses a declarative DSL (Groovy or Kotlin) to define builds. It combines the flexibility of Ant with Maven’s dependency management, and follows a task-based model with a focus on incremental builds and performance. Gradle is highly customizable and supports both convention and configuration, making it popular for complex and scalable projects.

```plaintext
project-root/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/App.java
│   │   └── resources/
│   └── test/
│       └── java/
│           └── com/example/AppTest.java
├── build.gradle
└── settings.gradle
```

```
javac -d <build directory> <source files>
java -cp <class path> <application>
```

gradle build

## Crafting with Gradle

## There and Back Again

Our adventurer has survived the journey - from the dark forests of Maven to the towers of Gradle -
and lived to tell the tale. Now, as every good story deserves, we turn to the reflections of one
who's been there and back again. Let's hear his hard-won lessons and insights from his epic
cross-realm adventure.

## The Council of Wizards

As our journey through the magical realms of Java build tools comes to a close, it's time to gather
as a council of wizards-sharing wisdom, answering questions and conjuring clarity. Step forward and
let your curiosities be heard!