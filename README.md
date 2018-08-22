Launcher
================
Launcher is a template for Web technology based Applications.
Based on Spring Boot it offers a specialised opinionated view on
how to modularise, implement and deploy such applications.

It is to be used and applied on an 'as is' basis with no guarantee of functionality.

[![Build Status](https://travis-ci.org/systemkern/launcher.svg?branch=master)](https://travis-ci.org/systemkern/launcher)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/1223c155302d4815a262b3c192158901)](https://www.codacy.com/app/systemkern/launcher?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=systemkern/launcher&amp;utm_campaign=Badge_Grade)
[![FOSSA Status](https://app.fossa.io/api/projects/git%2Bgithub.com%2Fsystemkern%2Flauncher.svg?type=shield)](https://app.fossa.io/projects/git%2Bgithub.com%2Fsystemkern%2Flauncher?ref=badge_shield)



Table of Contents
----------------

* [Launcher](#launcher)
  * [What is provided by this Template](#what-is-provided-by-this-template)
* [Application](#application)
  * [Application Configuration](#application-configuration)
  * [Logging Configuration](#logging-configuration)
  * [Assembly and Distribution](#assembly-and-distribution)
  * [Distribution configuration](#distribution-configuration)

___
If you'd like to contribute please read the [Contribution Guidelines](CONTRIBUTE.md)
This code is licensed under the [UNLICENSE](LICENSE)



The Goal
----------------
Even tough each project is different is different in a business sense,
there are still a lot of functionalities which overlap even between very
heterogeneous projects. Launcher aims to identify those overlaps and provide
dvelopers with a quickstart template.

This application template represents a strong opinionated view on the layout of Kotlin applications.
The layout is aimed at building a a _modularised monolith_ , which can easily be separated into
micro services at any point in time.



What is provided by this Template
----------------
* runtime for local execution including 
  * application configuration
  * logging configuration
* build and distribution configurations
  * bitbucket pipelines (bitbucket-pipelines.yml)
  * travis ci (github) .travis.yml
  * assembly of distributable as zip
  * via ftp (see ./pom.xml)
  * cli runtime for windows and linux
  * google app engine runtime
* integration testing of the REST api
* documentation generation with SpringRestDocs through the integratoin tests
* Template for a customer readme.html



Backlog 
================
* Integration Tests
* Project Setup
  * CI 
  * code analysis
  * CD
  * Runtime
  * Externalised Configuration
  * Modules
  * Docker
  * Security
* Rest API 
  * Documentation for Frontend Developers
  * Automatic client generation with Swagger
* Automatic Database Migration
* User Module
  * Registration & Confirmation
  * Authentication Provider
  * Password Reset
  * GDPR / DSGVO Compliance
  * Authentication Providers via Facebook, Google, Twitter, …
* Web Frontend








Application
================

### Application Configuration
Application configuration is done via standard spring-boot config providers
* application.properties is used for technical configuration
* application.yml can be used for business configuration

### Logging Configuration
Logging is done via the [Logback](https://logback.qos.ch/documentation.html) framework.
Logging configuration currently is only availible at compile time.

### Assembly and Distribution
For distribution of the assembled zip file via ftp call:
`mvn clean package wagon:upload-single`

### Distribution configuration
Ftp login credentials need to be configured in you maven settings xml.
Usually be found at ~/.m2/settings.xml

A custom settings file can also be generated by a shell command.
See bitbucket-pipelines.yml for an example

```
<settings>
  <servers>
    <server>
      <id>launcher-ftp-distribution-server</id>
      <username>myuseraccount</username>
      <password>s3cret</password>
    </server>
  </servers>
</settings>
```


## License
[![FOSSA Status](https://app.fossa.io/api/projects/git%2Bgithub.com%2Fsystemkern%2Flauncher.svg?type=large)](https://app.fossa.io/projects/git%2Bgithub.com%2Fsystemkern%2Flauncher?ref=badge_large)