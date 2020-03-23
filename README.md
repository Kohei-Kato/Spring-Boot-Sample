# Spring-Boot-Sample

TERASOLUNAガイドラインのアプリケーションのレイヤに基づいたSpring-Bootのサンプル。

＜TERASOLUNA Server Framework for Java (5.x) Development Guideline　2.4. アプリケーションのレイヤ化＞
http://terasolunaorg.github.io/guideline/5.5.1.RELEASE/ja/Overview/ApplicationLayering.html#applicationlayering

アプリケーションのほかに以下のサンプルも一般的なシステム開発で必要となる以下のサンプルも作成。  
（その他、必要なものがあれば追加する）

## ログ制御
Controller、Service、Repositoryなど各レイヤの呼び出し前後にAOPでログを差し込む制御。  
どの層で、どんな内容のログを、どのレベルで出力するかは未整理。  

- /Spring-Boot-Sample/src/main/java/com/example/sample/sysbase/interceptor/RestControllerInterceptor.java
- /Spring-Boot-Sample/src/main/java/com/example/sample/sysbase/interceptor/ServiceInterceptor.java
- /Spring-Boot-Sample/src/main/java/com/example/sample/sysbase/interceptor/RepositoryInterceptor.java

## 例外制御
Controllerが例外をthrowした場合にAOPでキャッチし、例外処理を実行。  
- /Spring-Boot-Sample/src/main/java/com/example/sample/sysbase/interceptor/SampleControllerAdvice.java  


## フィルタ制御 
リクエストURLよって個別の制御を差し込む。（未）


## 環境依存値取得 
application.ymlに設定した環境依存値の取得。  
ApplicationEnviroment 

## メッセージ管理 
application.ymlの`spring.message`配下で設定したpropertiesファイルでメッセージを管理。  
アプリケーションからはMessageResourceを利用してメッセージ取得。  

### 課題

- `messageSource.getMessage("app.message.sample.normal.001", null, Locale.JAPAN)`とするのは非常に冗長。
Localeの指定や埋め込み文字なしの場合のnull指定は省略したい。
- メッセージは大量になるため検索や置換のためExcelファイルで管理が望ましいと考える。よってExcelからプロパティファイルを生成できるツールが必要。


また、各レイヤの単体テストのひな形も作成。（作成中）


各クラスの詳細は以下フォルダに格納しているJavacdocに各パッケージの説明を記載。  
(構成や部品は随時検討し、追加、変更中）

https://github.com/Kohei-Kato/Spring-Boot-Sample/tree/master/doc


# 課題
## DEBUGログの内容の絞り込み
ログレベルをdebugにすると、デフォルトで大量の情報が出力されてしまう。必要のないものは出力しないようにする。
