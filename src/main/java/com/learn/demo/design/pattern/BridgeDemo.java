package com.learn.demo.design.pattern;

/**
 * @ClassName: BridgeDemo
 * @Description: 桥接模式
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

        scanService.scanBuy();

        scanService = new ScanServiceImpl(new ScanBuyService() {
            @Override
            public void buy() {
                System.out.println("TB 扫码购物");
            }
        }, null);

        scanService.scanBuy();

        scanService = new ScanServiceImpl(new ScanLoginService() {
            @Override
            public void login() {
                System.out.println("AiQiYi 登录");
            }
        });

        scanService.scanLogin();

        scanService = new ScanServiceImpl(new ScanLoginService() {
            @Override
            public void login() {
                System.out.println("WeiBo 登录");
            }
        });

        scanService.scanLogin();
    }

    interface ScanService {

        /**
         * 登录
         */
        void scanLogin();

        /**
         * 购物
         */
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

        public ScanServiceImpl(ScanBuyService scanBuyService) {
            this.scanBuyService = scanBuyService;
        }

        public ScanServiceImpl(ScanLoginService scanLoginService) {
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
