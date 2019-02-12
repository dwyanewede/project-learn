package com.learn.demo.interfaces;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: FunctionController
 * @Description: java类作用描述
 * @Author: 尚先生
 * @CreateDate: 2018/12/21 10:21
 * @Version: 1.0
 */
@RestController
public class FunctionController {

//    @Autowired
//    private DefaultServiceInvoker serviceInvoker;

    @GetMapping("/find/name")
    public String find() {

        UserService service = new UserService();
        DefaultServiceInvoker serviceInvoker = new DefaultServiceInvoker(service);

//         return serviceInvoker.invoke(new Function() {
//            @Override
//            public Object apply(Object o) {
//                return ((UserService) o).find(1);
//            }
//        }).toString();
        return serviceInvoker.invoke(func -> service.find(1)).toString();
    }
}
