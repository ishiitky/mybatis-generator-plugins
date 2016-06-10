# MyBatis Generator Plugins

MyBatis Generator で生成されるクラスを変更するプラグイン.  
具体的な処理は以下の通り.

* Mapperクラスのメソッド名,パラメータ名を変換する.またMapperファイルのメソッド名を変更する.
* MapperファイルをRepositoryファイル名に変更する.
* EntityクラスをLombokに対応させる.

本プログラムを使用する場合は Lombok をインストールしておいてください.

各プログラムは以下をベースとしています.

* https://github.com/dcendents/mybatis-generator-plugins
* https://github.com/softwareloop/mybatis-generator-lombok-plugin

## LombokPlugin

MyBatis Generatorで生成されるエンティティクラスはsetter/getterが実装済みである（自動生成）.  
Lombokでは,@Dataを付与すると自動的にsetter/getterを生成される(自動補完).  
そのためLombokを使用したほうがコード量が軽減される.  
本プラグインを使用することで,エンティティクラス生成時にsetter/getterメソッドを生成せず,@Dataを付与する.

## RenameClassNamePlugin

MyBatis Generator で生成されるクラス名を変更する.  
MyBatis Generator では,生成されるクラス名やxmlファイル名末尾はMapperとなる.本プラグインを使用してRepositoryに変更する.  
エンティティクラスのクラス名変更は,以下のプラグインで実施可能.  
`org.mybatis.generator.plugins.RenameExampleClassPlugin`

## RenameExampleClassAndMethodsPlugin

Exampleクラスのメソッドとパラメータ名を変更する.
メソッド名やパラメータ名をExampleからCriteriaに変更する場合は,generatorConfig.xmlに以下を追加.
```
<plugin type="mybatis.generator.plugins.RenameExampleClassAndMethodsPlugin">
	<property name="classMethodSearchString" value="Example" />
	<property name="classMethodReplaceString" value="Criteria" />
	<property name="parameterSearchString" value="example" />
	<property name="parameterReplaceString" value="criteria" />
</plugin>
```

## プラグインの使い方

https://github.com/ishiitky/mybatis-generator-sample