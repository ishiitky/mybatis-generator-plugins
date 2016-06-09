# MyBatis Generator Plugins

MyBatis Generator で生成されるクラスを変更するプラグイン。  
具体的な処理は以下の通り。

* Mapperクラスのメソッド名、パラメータ名を変換する。またMapperファイルのメソッド名を変更する。
* MapperファイルをRepositoryファイル名に変更する
* EntityクラスをLombokに対応させる

本プログラムを使用する場合は Lombok をインストールしておいてください。

各プログラムは以下をベースとしています。

* https://github.com/dcendents/mybatis-generator-plugins
* http://tech-blog.tsukaby.com/archives/47
* http://jyukutyo.hatenablog.com/entry/20110930/1317425066