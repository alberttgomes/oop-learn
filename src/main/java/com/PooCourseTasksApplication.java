package com.task;

import com.task.modules.Example;
import com.task.modules.one.MediaAgeExample;
import com.task.modules.one.SequentialStructureExample;
import com.task.modules.one.TradeExample;
import com.task.modules.two.IncomeTax;

public class PooCourseTasksApplication {

    public static void main(String[] args) {
        Example example = new SequentialStructureExample();

        example.execute();

        Example example1 = new MediaAgeExample();

        example1.execute();

        Example example2 = new TradeExample();

        example2.execute();

        Example example3 = new IncomeTax();

        example3.execute();
    }

}
