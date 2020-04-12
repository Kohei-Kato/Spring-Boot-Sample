package util;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

/**
 * テストで使用するユーティリティー.
 */
public class TestUtil {

  /**
   * "1111-1-1T1:1:1+09:00"のOffsetDateTimeインスタンスを作成.
   *
   * @return
   */
  public static OffsetDateTime get1111y1m1d1h1m1sTime() {
    return getInstatnce(1111, 1, 1, 1, 1, 1);
  }

  /**
   * "yyyy-mm-ddTHH:MM:SS+09:00"のOffsetDateTimeインスタンスを作成.
   *
   * @param yyyy
   * @param mm
   * @param dd
   * @param HH
   * @param MM
   * @param SS
   * @return
   */
  public static OffsetDateTime getInstatnce(int yyyy, int mm, int dd, int HH, int MM, int SS) {
    return OffsetDateTime.of(yyyy, mm, dd, HH, MM, SS, 0,ZoneOffset.of("+09:00"));
  }
}
