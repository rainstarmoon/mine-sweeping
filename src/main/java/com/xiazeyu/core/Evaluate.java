package com.xiazeyu.core;

import com.xiazeyu.exception.EvaluateException;
import com.xiazeyu.common.Config;
import com.xiazeyu.common.Info;
import com.xiazeyu.core.data.Decision;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 评估决策
 */
public class Evaluate {

    public static Integer execute() throws EvaluateException {
        if (Info.decisionSequence.isEmpty()) {
            return null;
        }
        for (Decision decision : Info.decisionSequence) {
            String cmd = decision.getCmd();
            Object[] params = decision.getParams();
            Class<?>[] paramsClass = new Class<?>[params.length];
            for (int i = 0; i < params.length; i++) {
                paramsClass[i] = params[i].getClass();
            }
            if (Config.decision_type_simple.equals(decision.getType())) {
                String[] cmdSplit = cmd.split(Config.cmd_separation_sign);
                String className = cmdSplit[0];
                String methodName = cmdSplit[1];
                try {
                    Class<?> classObj = Class.forName(className);
                    Method method = classObj.getMethod(methodName, paramsClass);
                    method.invoke(null, params);
                } catch (ClassNotFoundException e) {
                    throw new EvaluateException("生成的指令有误", e);
                } catch (NoSuchMethodException e) {
                    throw new EvaluateException("生成的指令有误", e);
                } catch (IllegalAccessException e) {
                    throw new EvaluateException("传递的参数有误", e);
                } catch (InvocationTargetException e) {
                    throw new EvaluateException("传递的参数有误", e);
                }
            }
        }
        return Info.decisionSequence.size();
    }

}
