# trans-core

trans-core is a java library for providing core functionality to process transactions. It
contains DTOs and validations (based on javax.validation package) to handle transactions. 

## Important Notes

- Few validations are added as an example for how validations could be added.
- In case the library code is being used within a container (e.g. Spring boot container) then 
the validations will be called automatically without the need to call ValidationManager. 

## Locale support

Error messages could be localized by passing locale to ValidationManager.validate method as follows:
```java
ValidationManager.validate(transaction, new Locale("ar"));
```
Note: In case of running the library code within a web container,
the code could be enhanced to get the message based on client locale.

## Importing

To import the library the following block should be added to build.gradle file:

```gradle
implementation('com.pos:trans-core:[version]')
```

## Cloning

Git cloning command may be used to clone the library source code as follows:

```bash
git clone https://github.com/AQaoud/trans-core.git
```

## Test cases

Test cases could be run by IDE or through gradle command on project root folder:
```bash
gradle test
```
