package com.example.sample.web.api001;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import base.TestBase;
import com.example.sample.sysbase.parts.CommonSytemParts;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.sample.web.api001.application.SampleControler;
import util.TestUtil;

import java.io.File;

@SpringBootTest
class SampleControllerTest extends TestBase {

  @Autowired private SampleControler sampleController;

  MockMvc mockMvc;

  @MockBean CommonSytemParts commonSytemParts;



  /** テスト資材の格納パス */
  private final String testResourcePath = resourcePath + "com/example/sample/web/api001/";

  @BeforeAll
  static void setUpBeforeClass() throws Exception {}

  @AfterAll
  static void tearDownAfterClass() throws Exception {}

  @BeforeEach
  void setUp() throws Exception {
    mockMvc = MockMvcBuilders.standaloneSetup(sampleController).build();
  }

  @AfterEach
  void tearDown() throws Exception {}

  /**
   * GETメソッドの正常系テスト.
   */
  @Nested
  class GetNormal {

    /** 本カテゴリのテスト資材の格納パス */
    private final String resourceGetNormalPath = testResourcePath + "get/Normal/";

    @DisplayName("正常系テスト.")
    @Test
    void test01() throws Exception {

      String testName = "test01";

      //--- 入力値
      //GETのためなし

      //--- 期待値
      String expectJson = readJsonFile(resourceGetNormalPath + testName +"/output.json");

      //--- モック設定
      // 現在時刻として「1111-1-1T1:1:1+09:00」を取得
      when(commonSytemParts.getCurrentTime()).thenReturn(TestUtil.get1111y1m1d1h1m1sTime());

      //--- API実行
      ResultActions result =
          mockMvc.perform(get("/sample").accept("application/json;charset=utf-8"));

      //---レスポンスのチェック
      //ステータスコードチェック
      result.andExpect(status().isOk());
      //レスポンスJSONの確認
      result.andExpect(content().string(expectJson));
    }
  }
}
