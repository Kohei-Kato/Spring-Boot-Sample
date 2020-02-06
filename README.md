# Spring-Boot-Sample

TERASOLUNAガイドラインのアプリケーションのレイヤに基づいたSpring-Bootのサンプル。

＜TERASOLUNA Server Framework for Java (5.x) Development Guideline　2.4. アプリケーションのレイヤ化＞
http://terasolunaorg.github.io/guideline/5.5.1.RELEASE/ja/Overview/ApplicationLayering.html#applicationlayering

アプリケーションのほかに以下のサンプルも一般的なシステム開発で必要となる以下のサンプルも作成。  
（その他、必要なものがあれば追加する）

| 機能           | 説明                                                               | 実装クラス                          |
|----------------|--------------------------------------------------------------------|-------------------------------------|
| ログ制御       | 各レイヤの呼び出し前後にAOPでログを差し込む制御                    | HttpRequestHandlerInterceptor、など |
| 例外制御       | Controllerが例外をthrowした場合にAOPでキャッチし、例外処理を実行。 | ExceptionInterceptor                |
| フィルタ制御   | リクエストURLよって個別の制御を差し込む。                          | 未                                  |
| 環境依存値取得 | application.ymlに設定した環境依存値の取得。                        | ApplicationEnviroment               |


また、各レイヤの単体テストのひな形も作成。（作成中）


各クラスの詳細は以下フォルダに格納しているJavacdocに各パッケージの説明を記載。  
(構成や部品は随時検討し、追加、変更中）

https://github.com/Kohei-Kato/Spring-Boot-Sample/tree/master/doc
