package cn.lihui.resolver;


import cn.lihui.exception.MoneyException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ghy
 */
public class MyExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView mv = new ModelAndView();

        String exMsg = null;

        MoneyException moneyException;

        if(ex instanceof MoneyException) {
            moneyException = (MoneyException) ex;
            exMsg = moneyException.getMessage();
        }
        mv.addObject("exMsg",exMsg);
        mv.setViewName("error");
        return mv;
    }
}
