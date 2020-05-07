package q005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Q005 データクラスと様々な集計
 * <p>
 * 以下のファイルを読み込んで、WorkDataクラスのインスタンスを作成してください。
 * resources/q005/data.txt
 * (先頭行はタイトルなので読み取りをスキップする)
 * <p>
 * 読み込んだデータを以下で集計して出力してください。
 * (1) 役職別の合計作業時間
 * (2) Pコード別の合計作業時間
 * (3) 社員番号別の合計作業時間
 * 上記項目内での出力順は問いません。
 * <p>
 * 作業時間は "xx時間xx分" の形式にしてください。
 * また、WorkDataクラスは自由に修正してください。
 * <p>
 * [出力イメージ]
 * 部長: xx時間xx分
 * 課長: xx時間xx分
 * 一般: xx時間xx分
 * Z-7-31100: xx時間xx分
 * I-7-31100: xx時間xx分
 * T-7-30002: xx時間xx分
 * （省略）
 * 194033: xx時間xx分
 * 195052: xx時間xx分
 * 195066: xx時間xx分
 * （省略）
 */
public class Q005 {
    /**
     * ヘッダー判定文字
     */
    private static final String HEADER = "社員番号";

    /**
     * データファイルを開く
     * resources/q003/data.txt
     */
    private static InputStream openDataFile() {
        return Q005.class.getResourceAsStream("data.txt");
    }

    public static void main(String[] args) {
        List<WorkData> workDataList = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(openDataFile()));
        try {
            String data;
            while ((data = reader.readLine()) != null) {
                if (data.startsWith(HEADER)) {
                    continue;
                }
                String[] item = data.split(",");
                WorkData workData = new WorkData(item[0], item[1], item[2], item[3], Integer.parseInt(item[4]));
                workDataList.add(workData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // (1) 役職別の合計作業時間
        aggregateByPosition(workDataList).forEach((k, v) ->
        {
            int hour = v / 60;
            int min = v - hour * 60;
            System.out.println(k + ": " + hour + "時間" + min + "分");
        });

        // (2) Pコード別の合計作業時間
        aggregateByPCode(workDataList).forEach((k, v) ->
        {
            int hour = v / 60;
            int min = v - hour * 60;
            System.out.println(k + ": " + hour + "時間" + min + "分");
        });

        // (3) 社員番号別の合計作業時間
        aggregateByNumber(workDataList).forEach((k, v) ->
        {
            int hour = v / 60;
            int min = v - hour * 60;
            System.out.println(k + ": " + hour + "時間" + min + "分");
        });
    }

    private static Map<String, Integer> aggregateByPosition(List<WorkData> workDataList) {
        Map<String, Integer> map = new HashMap<>();
        for (WorkData w : workDataList) {
            String position = w.getPosition();
            Integer workTime = w.getWorkTime();
            map.merge(position, workTime, Integer::sum);
        }
        return map;
    }

    private static Map<String, Integer> aggregateByPCode(List<WorkData> workDataList) {
        Map<String, Integer> map = new HashMap<>();
        for (WorkData w : workDataList) {
            String pCode = w.getpCode();
            Integer workTime = w.getWorkTime();
            map.merge(pCode, workTime, Integer::sum);
        }
        return map;
    }

    private static Map<String, Integer> aggregateByNumber(List<WorkData> workDataList) {
        Map<String, Integer> map = new HashMap<>();
        for (WorkData w : workDataList) {
            String number = w.getNumber();
            Integer workTime = w.getWorkTime();
            map.merge(number, workTime, Integer::sum);
        }
        return map;
    }
}


// 完成までの時間: 1時間 20分