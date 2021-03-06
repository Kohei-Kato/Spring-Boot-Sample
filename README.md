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
リクエストURLよって個別の制御を差し込む。

### ＜実装クラス＞
フィルタ本体
- com.example.sample.sysbase.filter.SampleFilter
- com.example.sample.sysbase.filter.SampleFilter2

フィルタの登録
- com.example.sample.sysbase.config.FilterConfig

### ＜処理概要＞
フィルタの登録時にフィルタが反応するURLパターンを指定。  
SampleFilterは全URL（/*）、SampleFilter2はSampleController（/sample/*）へのリクエストの場合に反応するようにした。

### ＜課題＞
フィルタが反応するURLを外部化し、自由に変更できるようにする。

### ＜参考URL＞
- Spring BootでFilterを利用してみた  
https://www.purin-it.com/spring-boot-filter1

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

## 単体テスト

### レイヤごとのテストの作成テンプレート

#### ＜課題＞


### テスト資材の配置構成

```
test
├─java.com.example.web
│  └─api001                          　①API単位でフォルダを作成
│        SampleControllerTest.java
│
└─resources
    └─com.example.sample.web
         └─api001                      ①API単位でフォルダを作成
             └─GetNormal               ①APIのメソッド＋Nromal（正常系）、Error(異常系)、Validate(入力チェック)単位でフォルダを作成
                  └─test01             ③テストメソッド名
                       └─output.json
                             

```

#### ＜課題＞
- テストクラスが複数になった場合、上記のルールだと資材フォルダが作成できない。

# 全体課題
## DEBUGログの内容の絞り込み
ログレベルをdebugにすると、デフォルトで大量の情報が出力されてしまう。必要のないものは出力しないようにする。
