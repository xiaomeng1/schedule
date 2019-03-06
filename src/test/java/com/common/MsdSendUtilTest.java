package com.common;

import com.utils.MsdSendUtil;
import org.junit.Test;

/**
 * Created by mengxi on 2019/1/17.
 */
public class MsdSendUtilTest {

    @Test
    public void sendMsgTest() {
        MsdSendUtil.sendMsgForDefaultTemplate("17621203923","xiaomeng");
    }
}
