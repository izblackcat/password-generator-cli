# Password Generator


This is my first app using Spring Shell. 
For curiousity I wanted to start with Spring Shell by creating a simple side-project app and this is the idea I got. It's simple and hopefully efficient. 


## Features : 
- [x] generate random password with a custom lengths
- [x] choose characters to be included or excluded
- [x] generate multiple passwords
- [ ] choose complexity requirements: number of uppercase, numbers, special characters...
- [ ] history of generated passwords
- [ ] save passwords to a file (a tag)
- [ ] GraalVM native support

## How to use:

1. clone the repository
```shell
git clone 
```

2. Run the command below (you need Maven installed) 

```shell
mvn clean test
```

3. Run the app

```shell
mvn spring-boot:run
```

4. Once the app starts, type to display the available commands: 
```shell
help
```

5. You can type the following command to see the datails of a command : 
```shell
help 'command'
```
