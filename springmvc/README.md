# Goal

練習 Springboot & Spring MVC 的使用


1. properties 注入設定檔:
- 使用 @Value 注入設定檔: ProjectConfig
- 使用 Enviroment 介面 注入設定檔: ProjectEnvConfig
- 使用 @ConfigurationProperties 注入設定檔: ProjectConfigurationPropertiesConfig

2. YAML 注入設定檔:
- 自定義 YamlPropertySourceFactory 覆寫轉換 YAML to properties 格式的規格

3. Handler Method Arguments:
- @MatrixVariable 使用 : MatrixVariablesDemoController
- @ModelAttribute 使用 : ModelAttributeDemoController