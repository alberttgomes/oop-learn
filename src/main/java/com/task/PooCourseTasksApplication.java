package com.task;

import com.task.modules.Example;
import com.task.modules.one.MediaAgeExample;
import com.task.modules.one.SequentialStructureExample;
import com.task.modules.one.TradeExample;
import com.task.modules.two.Athletes;
import com.task.modules.two.IncomeTax;

public class PooCourseTasksApplication {

    public static void main(String[] args) {
        Example example = new Athletes();

        example.execute();
    }

}
