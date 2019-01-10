package com.learn.demo.design.pattern;

/**
 * @ClassName: BridgeDemo
 * @Description: java类作用描述
 * @Author: 尚先生
 * @CreateDate: 2018/12/19 10:48
 * @Version: 1.0
 */
public class BridgeDemo {

    // 桥接模式
    // 对客户端而言只关心粗粒度接口，具体执行方法是有运行时初始化而定
    public static void main(String[] args) {
        ScanService scanService = new ScanServiceImpl(new ScanBuyService() {
            @Override
            public void buy() {
                System.out.println("JD 扫码购物");
            }
        }, null);

        scanService = new ScanServiceImpl(new ScanBuyService() {
            @Override
            public void buy() {
                System.out.println("TM 扫码购物");
            }
        }, null);

        scanService.scanBuy();
    }

    interface ScanService {
        void scanLogin();

        void scanBuy();
    }

    interface ScanBuyService {
        void buy();
    }

    interface ScanLoginService {
        void login();
    }


    static class ScanServiceImpl implements ScanService {

        private ScanBuyService scanBuyService;

        private ScanLoginService scanLoginService;

        public ScanServiceImpl(ScanBuyService scanBuyService, ScanLoginService scanLoginService) {
            this.scanBuyService = scanBuyService;
            this.scanLoginService = scanLoginService;
        }

        @Override
        public void scanLogin() {

            scanLoginService.login();
        }

        @Override
        public void scanBuy() {
            scanBuyService.buy();
        }
    }
}
