package base;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;

public class TestBase {

    /** テスト資材の格納パス */
    protected final String resourcePath = "./src/test/resources/";


    /**
     * 指定されたファイルのJSONを読み込み、返却.
     * @param filePath 読み込み対象のファイル
     * @return ファイル内のJSON文字列.
     * @throws IOException
     */
    protected String readJsonFile(String filePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.WRAP_ROOT_VALUE);
        return  mapper.readTree(new File(filePath)).toString();
    }

}
