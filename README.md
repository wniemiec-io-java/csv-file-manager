![](https://github.com/wniemiec-io-java/csv-file-manager/blob/master/docs/img/logo/logo.jpg)

<h1 align='center'>CSV File Manager</h1>
<p align='center'>Read and write csv files.</p>
<p align="center">
	<a href="https://github.com/wniemiec-io-java/csv-file-manager/actions/workflows/windows.yml"><img src="https://github.com/wniemiec-io-java/csv-file-manager/actions/workflows/windows.yml/badge.svg" alt=""></a>
	<a href="https://github.com/wniemiec-io-java/csv-file-manager/actions/workflows/macos.yml"><img src="https://github.com/wniemiec-io-java/csv-file-manager/actions/workflows/macos.yml/badge.svg" alt=""></a>
	<a href="https://github.com/wniemiec-io-java/csv-file-manager/actions/workflows/ubuntu.yml"><img src="https://github.com/wniemiec-io-java/csv-file-manager/actions/workflows/ubuntu.yml/badge.svg" alt=""></a>
	<a href="https://codecov.io/gh/wniemiec-io-java/csv-file-manager"><img src="https://codecov.io/gh/wniemiec-io-java/csv-file-manager/branch/master/graph/badge.svg?token=R2SFS4SP86" alt="Coverage status"></a>
	<a href="http://java.oracle.com"><img src="https://img.shields.io/badge/java-11+-D0008F.svg" alt="Java compatibility"></a>
	<a href="https://mvnrepository.com/artifact/io.github.wniemiec-io-java/csv-file-manager"><img src="https://img.shields.io/maven-central/v/io.github.wniemiec-io-java/csv-file-manager" alt="Maven Central release"></a>
	<a href="https://github.com/wniemiec-io-java/csv-file-manager/blob/master/LICENSE"><img src="https://img.shields.io/github/license/wniemiec-io-java/csv-file-manager" alt="License"></a>
</p>
<hr />

## ❇ Introduction
CSV File Manager performs operations with csv files simply and easily.

## ❓ How to use
1. Add one of the options below to the pom.xml file: 

#### Using Maven Central (recomended):
```
<dependency>
  <groupId>io.github.wniemiec-io-java</groupId>
  <artifactId>csv-file-manager</artifactId>
  <version>LATEST</version>
</dependency>
```

#### Using GitHub Packages:
```
<dependency>
  <groupId>wniemiec.io.java</groupId>
  <artifactId>csv-file-manager</artifactId>
  <version>LATEST</version>
</dependency>
```

2. Run
```
$ mvn install
```

3. Use it
```
[...]

import wniemiec.io.java.CsvFileManager;

[...]

List<String> firstLine = List.of("hello", "world");
List<String> secondLine = List.of("world", "hello");
File directory = new File(".");

CsvFileManager csvFileManager = new CsvFileManager(directory, "example-file.csv");
csvFileManager.writeLine(firstLine);
csvFileManager.writeLine(secondLine);

System.out.println( csvFileManager.readLines() );

[...]
```


## 📖 Documentation
|        Property        |Parameter type|Return type|Description|Default parameter value|
|----------------|-------------------------------|-----|------------------------|--------|
|readLines |`separator: String`|`List<List<String>>`|Reads exported CSV file and returns a Map with its content| `","` |
|writeLine |`line: List<String>, separator: String`|`void`|Writes a content to a CSV file| - , `","` |
|writeLines |`lines: List<List<String>>, separator: String`|`void`|Writes a content to a CSV file| - , `","` |
|delete|`void`|`void`|Removes CSV file| - |
|exists|`void`|`boolean`| Checks whether the CSV file exists | - |

## 🚩 Changelog
Details about each version are documented in the [releases section](https://github.com/williamniemiec/wniemiec-io-java/csv-file-manager/releases).

## 🤝 Contribute!
See the documentation on how you can contribute to the project [here](https://github.com/wniemiec-io-java/csv-file-manager/blob/master/CONTRIBUTING.md).

## 📁 Files

### /
|        Name        |Type|Description|
|----------------|-------------------------------|-----------------------------|
|dist |`Directory`|Released versions|
|docs |`Directory`|Documentation files|
|src     |`Directory`| Source files|
