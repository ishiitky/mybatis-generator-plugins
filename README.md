# MyBatis Generator Plugins

MyBatis Generator で生成されるクラスを変更するプラグイン。  
具体的な処理は以下の通り。

* Mapperクラスのメソッド名、パラメータ名を変換する。またMapperファイルのメソッド名を変更する。
* MapperファイルをRepositoryファイル名に変更する
* EntityクラスをLombokに対応させる

参考となるプラグインの資料

* https://github.com/dcendents/mybatis-generator-plugins