# Summon your build tool

## Intro

Many new Java developers feel like first-years at Codewarts, nervously waiting for the Sorting Hat
to decide their fate — the choice is between Maven or Gradle - or Ant :-P. In this hands-on tech
talk, we'll guide you through the "sorting ceremony" of Java build tools, helping you understand
their strengths, quirks and ideal use cases so you can confidently wear the hat that fits your
project.

## Ready?

You are ready if you have Git for Windows (Git Bash) and a JDK installed. Or are otherwise running
on Linux or a Mac. We'll show you how to install the build tools. Ensure the `JAVA_HOME`
environment variable is set to your JDK folder.

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

Tool: JDK\
Values: Self-reliance, understanding, courage\
Motto: "True mastery needs no wand - only will." Coders of Javador are the old souls of the Java
world - methodical, disciplined and unafraid to get their hands dirty with javac and jar commands.
They can summon .class files from thin air using nothing but a terminal.

* Build: `javac -d build src/main/java/codewarts/SortingHat.java`
* Run: `java -cp build codewarts.SortingHat`
* Clean: `rm -rf build`

## Makeclaw

Tool: GNU Make\
Values: Tradition, craftsmanship, simplicity\
Motto: "One target at a time." Makeclaw coders respect the old ways - concise scripts, manual
mastery and control over every rule. Their Makefiles are like spell scrolls: cryptic, but powerful.

- If you are on Windows and don't have Make installed, go to
  [ezwinports](https://sourceforge.net/projects/ezwinports/files/)
  - download `make-4.4.1-without-guile-w32-bin.zip`
  - extract and copy `make.exe` to the project root.
- Edit [`Makefile`](Makefile).

* Build: `./make`
* Run: `./make run`
* Clean: `./make clean`

## Antforge

Tool: Apache Ant\
Values: Structure, persistence and XML sorcery\
House Motto: "No build too big, no tag too tangled." Antforgers believe in clarity and order. They
trust in XML incantations to keep chaos at bay - though their build files sometimes grow into
ancient grimoires.

- Go to [Apache Ant](https://ant.apache.org/), download and extract the downloaded file.
- Set the environment variables:
  - `ANT_HOME` to the extracted file location.
  - Add `$ANT_HOME/bin` to `PATH`.
- Go to [Apache Ivy](https://ant.apache.org/ivy/), download, extract, locate the JAR file and copy
  it into your Ant installation:
  - `cp ivy-<VERSION>.jar $ANT_HOME/lib/`
- Edit [`build.xml`](build.xml) and [`ivy.xml`](ivy.xml).

* Build: `ant`
* Run: `ant run`
* Clean: `ant clean`

## Mavenmere

Tool: Apache Maven\
Values: Convention, knowledge, dependency mastery\
House Motto: "By the power of POM." The Mavenmeres channel the strength of repositories and
artifacts. They build with a single command and trust the magic of convention over configuration.

- Go to [Apache Maven](https://maven.apache.org/), download and extract the downloaded file.
- Add the `bin` folder of the extracted Maven installation to the `PATH` environment variable.
- Edit [`pom.xml`](pom.xml).

* Build: `mvn compile`
* Run: `mvn exec:java`
* Clean: `mvn clean`
* Test: `mvn test`

## Gradlewraith

Tool: Gradle
Values: Modernity, flexibility, automation
House Motto: "Build fast, script freely."
Gradlewraiths combine the best of magic and scripting. They weave Groovy and Kotlin spells to automate everything and summon productivity from thin air.

 mvn package
 gradle build
