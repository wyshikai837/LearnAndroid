package com.sky.learnandroid.paddleocr;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.equationl.paddleocr4android.CpuPowerMode;
import com.equationl.paddleocr4android.OCR;
import com.equationl.paddleocr4android.OcrConfig;
import com.equationl.paddleocr4android.Util.paddle.OcrResultModel;
import com.equationl.paddleocr4android.bean.OcrResult;
import com.equationl.paddleocr4android.callback.OcrInitCallback;
import com.equationl.paddleocr4android.callback.OcrRunCallback;
import com.sky.learnandroid.R;

import java.util.List;

public class TestPaddleOcrActivityivity extends AppCompatActivity {

    private static final String TAG = "TestPaddleOcrActivityiv";

    public static void startActivity(Activity activity) {
        Intent intent = new Intent(activity, TestPaddleOcrActivityivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_paddle_ocr_activityivity);
        initPaddlOcr();
    }

    private void initPaddlOcr() {
        OcrConfig config = new OcrConfig();
//        config.setModelPath("models"); // 不使用 "/" 开头的路径表示安装包中 assets 目录下的文件，例如当前表示 assets/models/ocr_v2_for_cpu
////config.modelPath = "/sdcard/Android/data/com.equationl.paddleocr4android.app/files/models" // 使用 "/" 表示手机储存路径，测试时请将下载的三个模型放置于该目录下
//        config.setClsModelFileName("cls"); // cls 模型文件名
//        config.setDetModelFileName("det"); // det 模型文件名
//        config.setRecModelFileName("rec"); // rec 模型文件名
//// 运行全部模型
//        config.setRunType(RunType.All);


        config.setModelPath("models/ch_PP-OCRv2");
        config.setClsModelFilename("cls.nb"); // cls 模型文件名
        config.setDetModelFilename("det_db.nb"); // det 模型文件名
        config.setRecModelFilename("rec_crnn.nb"); // rec 模型文件名

        config.setRunCls(true);
        config.setRunDet(true);
        config.setRunRec(true);

        // 使用所有核心运行
        config.setCpuPowerMode(CpuPowerMode.LITE_POWER_FULL);

        // 绘制文本位置
        config.setDrwwTextPositionBox(true);

// 如果是原始模型，则使用 FP16 精度
//        config.setRecRunPrecision(RunPrecision.LiteFp16);
//        config.setDetRunPrecision(RunPrecision.LiteFp16);
//        config.setClsRunPrecision(RunPrecision.LiteFp16);

// 如果是量化模型则使用 int8 精度
//config.recRunPrecision = RunPrecision.LiteInt8
//config.detRunPrecision = RunPrecision.LiteInt8
//config.clsRunPrecision = RunPrecision.LiteInt8

// 1.同步初始化
/*ocr.initModelSync(config).fold(
    {
        if (it) {
            Log.i(TAG, "onCreate: init success")
        }
    },
    {
        it.printStackTrace()
    }
)*/

// 2.异步初始化
        final OCR ocr = new OCR(this);
        ocr.initModel(config, new OcrInitCallback() {
            @Override
            public void onSuccess() {
                Log.e(TAG, "---> onSuccess: 初始化成功");

                // 1.同步识别
/*val bitmap = BitmapFactory.decodeResource(resources, R.drawable.test2)
ocr.runSync(bitmap)

val bitmap2 = BitmapFactory.decodeResource(resources, R.drawable.test3)
ocr.runSync(bitmap2)*/

// 2.异步识别
                Bitmap bitmap3 = BitmapFactory.decodeResource(getResources(), R.drawable.test4);
                ocr.run(bitmap3, new OcrRunCallback() {
                    @Override
                    public void onSuccess(@NonNull OcrResult ocrResult) {
                        Log.e(TAG, "---> onSuccess: 识别成功");
                        String simpleText = ocrResult.getSimpleText();
                        Bitmap imgWithBox = ocrResult.getImgWithBox();
                        float inferenceTime = ocrResult.getInferenceTime();
                        List<OcrResultModel> outputRawResult = ocrResult.getOutputRawResult();

                        String text = String.format("识别文字=\n%s\n识别时间=%f ms\n更多信息=\n", simpleText, inferenceTime);

                        for (OcrResultModel resultModel : outputRawResult) {
                            text += String.format("文字方向：%s；文字方向置信度：%f；识别置信度 %f；；\n", resultModel.getClsLabel(),
                                    resultModel.getClsConfidence(), resultModel.getConfidence());
                        }

                        Log.e(TAG, "---> onSuccess: 识别结果：" + text);
                    }

                    @Override
                    public void onFail(@NonNull Throwable throwable) {
                        Log.e(TAG, "---> onFail: 识别失败");
                    }
                });
            }

            @Override
            public void onFail(@NonNull Throwable throwable) {
                Log.e(TAG, "---> onFail: 初始化失败");
            }
        });
    }
}