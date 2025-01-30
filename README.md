# infra-scaffold

`infra-scaffold` 是从 [sample](https://github.com/xincao9/infra-framework/tree/main/sample) 项目导出的原型模板，用于快速生成基础设施项目。

## [使用说明](https://maven.apache.org/archetype/maven-archetype-plugin/advanced-usage.html)

### 1. 导出原型模板

在你的项目中执行以下命令，导出原型模板：

```bash
mvn archetype:create-from-project
```

该命令将会基于当前项目生成一个 Maven 原型模板。

### 2. 安装原型模板到本地

执行以下命令，将生成的原型模板安装到本地 Maven 仓库中：

```bash
cd target/generated-sources/archetype/
```

然后运行：

```bash
mvn install
```

### 3. 使用原型模板生成新项目

在本地仓库中安装完成后，你就可以使用该原型模板来创建新的项目了。执行以下命令来生成项目：

```bash
mvn archetype:generate -DarchetypeCatalog=local
```

这样 Maven 会从本地仓库加载模板，并生成新项目。

## 注意事项

- 确保你已经安装了 Maven，并且版本符合要求。
- 在执行命令时，当前目录应该是你的项目根目录或模板所在目录。

---
