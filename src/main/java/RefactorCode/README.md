### 概述
本段内容基于《重构——改善既有代码的设计》一书进行实操。

这是一个影片出租用的程序，计算每个顾客的消费金额并打印详单。操作者告诉程序：
顾客租了哪些影片，租期多长，程序便根据租赁时间和影片类型算出费用。
影片分为三类：普通片，儿童片和新片。
除了计算费用，还要为常客计算积分，积分会根据租片种类是否为新片尔有所不同。

1.增加可靠的测试，避免重构引入新的bug

2.分解重组复杂的代码块，提炼函数。

3.在分解完毕之后，重命名内部变量以及函数名，使其清楚表达自己的功能。

4.搬移函数。如果一个类的很多行为和另一个类有着高度耦合，就会存在**代码依恋**。
    如果是完全依恋，可以直接 `move method` 迁移至目标类；
    如果是部分依赖，可以先进行`Extract Method`,将函数提炼出更小粒度的代码，然后再进行`move method` 迁移至目标类。

5.通过设计模式进行重构，通过策略模式/状态机模式来对不同的类型进行处理，进一步简化代码。
