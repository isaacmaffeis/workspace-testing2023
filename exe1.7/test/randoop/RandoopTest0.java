package randoop;

import static org.junit.Assert.*;

import org.junit.Test;

package randoop;

import junit.framework.*;

public class RandoopTest0 extends TestCase {

  public static boolean debug = false;

  public void test1() throws Throwable {

    if (debug) System.out.printf("%nRandoopTest0.test1");


    esercizio0.Rettangolo var2 = new esercizio0.Rettangolo(10, 1);
    int var3 = var2.getAltezza();
    int var4 = var2.getBase();
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var3 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var4 == 10);

  }

  public void test2() throws Throwable {

    if (debug) System.out.printf("%nRandoopTest0.test2");


    esercizio0.Rettangolo var2 = new esercizio0.Rettangolo(10, 100);
    int var3 = var2.getAltezza();
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var3 == 100);

  }

  public void test3() throws Throwable {

    if (debug) System.out.printf("%nRandoopTest0.test3");


    esercizio0.Rettangolo var2 = new esercizio0.Rettangolo((-1), 1);
    int var3 = var2.getAltezza();
    int var4 = var2.getAltezza();
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var3 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var4 == 1);

  }

  public void test4() throws Throwable {

    if (debug) System.out.printf("%nRandoopTest0.test4");


    esercizio0.Rettangolo var2 = new esercizio0.Rettangolo((-1), 1);
    int var3 = var2.getBase();
    int var4 = var2.getBase();
    int var5 = var2.getAltezza();
    int var6 = var2.getBase();
    int var7 = var2.getBase();
    int var8 = var2.getAltezza();
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var3 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var4 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var5 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var6 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var7 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var8 == 1);

  }

  public void test5() throws Throwable {

    if (debug) System.out.printf("%nRandoopTest0.test5");


    esercizio0.Rettangolo var2 = new esercizio0.Rettangolo(100, 1);
    int var3 = var2.getBase();
    int var4 = var2.getBase();
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var3 == 100);
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var4 == 100);

  }

  public void test6() throws Throwable {

    if (debug) System.out.printf("%nRandoopTest0.test6");


    esercizio0.Rettangolo var2 = new esercizio0.Rettangolo((-1), 0);
    int var3 = var2.getAltezza();
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var3 == 0);

  }

  public void test7() throws Throwable {

    if (debug) System.out.printf("%nRandoopTest0.test7");


    esercizio0.Rettangolo var2 = new esercizio0.Rettangolo(0, 100);

  }

  public void test8() throws Throwable {

    if (debug) System.out.printf("%nRandoopTest0.test8");


    esercizio0.Rettangolo var2 = new esercizio0.Rettangolo(10, 100);
    int var3 = var2.getBase();
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var3 == 10);

  }

  public void test9() throws Throwable {

    if (debug) System.out.printf("%nRandoopTest0.test9");


    esercizio0.Rettangolo var2 = new esercizio0.Rettangolo(10, 1);
    int var3 = var2.getBase();
    int var4 = var2.getBase();
    int var5 = var2.getAltezza();
    int var6 = var2.getBase();
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var3 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var4 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var5 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var6 == 10);

  }

  public void test10() throws Throwable {

    if (debug) System.out.printf("%nRandoopTest0.test10");


    esercizio0.Rettangolo var2 = new esercizio0.Rettangolo(1, (-1));

  }

  public void test11() throws Throwable {

    if (debug) System.out.printf("%nRandoopTest0.test11");


    esercizio0.Rettangolo var2 = new esercizio0.Rettangolo((-1), 1);
    int var3 = var2.getAltezza();
    int var4 = var2.getBase();
    int var5 = var2.getAltezza();
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var3 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var4 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var5 == 1);

  }

  public void test12() throws Throwable {

    if (debug) System.out.printf("%nRandoopTest0.test12");


    esercizio0.Rettangolo var2 = new esercizio0.Rettangolo(10, 0);
    int var3 = var2.getAltezza();
    int var4 = var2.getBase();
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var4 == 10);

  }

  public void test13() throws Throwable {

    if (debug) System.out.printf("%nRandoopTest0.test13");


    esercizio0.Rettangolo var2 = new esercizio0.Rettangolo((-1), 100);
    int var3 = var2.getAltezza();
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var3 == 100);

  }

  public void test14() throws Throwable {

    if (debug) System.out.printf("%nRandoopTest0.test14");


    esercizio0.Rettangolo var2 = new esercizio0.Rettangolo(1, 10);
    int var3 = var2.getBase();
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var3 == 1);

  }

  public void test15() throws Throwable {

    if (debug) System.out.printf("%nRandoopTest0.test15");


    esercizio0.Rettangolo var2 = new esercizio0.Rettangolo((-1), 1);
    int var3 = var2.getBase();
    int var4 = var2.getBase();
    int var5 = var2.getAltezza();
    int var6 = var2.getBase();
    int var7 = var2.getAltezza();
    int var8 = var2.getAltezza();
    int var9 = var2.getBase();
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var3 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var4 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var5 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var6 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var7 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var8 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var9 == (-1));

  }

  public void test16() throws Throwable {

    if (debug) System.out.printf("%nRandoopTest0.test16");


    esercizio0.Rettangolo var2 = new esercizio0.Rettangolo(100, 1);
    int var3 = var2.getAltezza();
    int var4 = var2.getAltezza();
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var3 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var4 == 1);

  }

  public void test17() throws Throwable {

    if (debug) System.out.printf("%nRandoopTest0.test17");


    esercizio0.Rettangolo var2 = new esercizio0.Rettangolo(10, (-1));
    int var3 = var2.getAltezza();
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var3 == (-1));

  }

  public void test18() throws Throwable {

    if (debug) System.out.printf("%nRandoopTest0.test18");


    esercizio0.Rettangolo var2 = new esercizio0.Rettangolo(10, 1);
    int var3 = var2.getBase();
    int var4 = var2.getBase();
    int var5 = var2.getBase();
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var3 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var4 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var5 == 10);

  }

  public void test19() throws Throwable {

    if (debug) System.out.printf("%nRandoopTest0.test19");


    esercizio0.Rettangolo var2 = new esercizio0.Rettangolo(100, 1);
    int var3 = var2.getBase();
    int var4 = var2.getAltezza();
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var3 == 100);
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var4 == 1);

  }

  public void test20() throws Throwable {

    if (debug) System.out.printf("%nRandoopTest0.test20");


    esercizio0.Rettangolo var2 = new esercizio0.Rettangolo(10, 1);
    int var3 = var2.getBase();
    int var4 = var2.getAltezza();
    int var5 = var2.getAltezza();
    int var6 = var2.getBase();
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var3 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var4 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var5 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var6 == 10);

  }

  public void test21() throws Throwable {

    if (debug) System.out.printf("%nRandoopTest0.test21");


    esercizio0.Rettangolo var2 = new esercizio0.Rettangolo((-1), 100);
    int var3 = var2.getBase();
    int var4 = var2.getBase();
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var3 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var4 == (-1));

  }

  public void test22() throws Throwable {

    if (debug) System.out.printf("%nRandoopTest0.test22");


    esercizio0.Rettangolo var2 = new esercizio0.Rettangolo((-1), 0);
    int var3 = var2.getBase();
    int var4 = var2.getBase();
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var3 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var4 == (-1));

  }

  public void test23() throws Throwable {

    if (debug) System.out.printf("%nRandoopTest0.test23");


    esercizio0.Rettangolo var2 = new esercizio0.Rettangolo(1, 100);
    int var3 = var2.getAltezza();
    int var4 = var2.getAltezza();
    int var5 = var2.getAltezza();
    int var6 = var2.getBase();
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var3 == 100);
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var4 == 100);
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var5 == 100);
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var6 == 1);

  }

  public void test24() throws Throwable {

    if (debug) System.out.printf("%nRandoopTest0.test24");


    esercizio0.Rettangolo var2 = new esercizio0.Rettangolo((-1), (-1));

  }

  public void test25() throws Throwable {

    if (debug) System.out.printf("%nRandoopTest0.test25");


    esercizio0.Rettangolo var2 = new esercizio0.Rettangolo((-1), 0);
    int var3 = var2.getBase();
    int var4 = var2.getAltezza();
    int var5 = var2.getAltezza();
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var3 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var4 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var5 == 0);

  }

  public void test26() throws Throwable {

    if (debug) System.out.printf("%nRandoopTest0.test26");


    esercizio0.Rettangolo var2 = new esercizio0.Rettangolo(0, 10);
    int var3 = var2.getAltezza();
    int var4 = var2.getAltezza();
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var3 == 10);
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var4 == 10);

  }

  public void test27() throws Throwable {

    if (debug) System.out.printf("%nRandoopTest0.test27");


    esercizio0.Rettangolo var2 = new esercizio0.Rettangolo(10, 10);
    int var3 = var2.getBase();
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var3 == 10);

  }

  public void test28() throws Throwable {

    if (debug) System.out.printf("%nRandoopTest0.test28");


    esercizio0.Rettangolo var2 = new esercizio0.Rettangolo((-1), 1);
    int var3 = var2.getBase();
    int var4 = var2.getBase();
    int var5 = var2.getAltezza();
    int var6 = var2.getBase();
    int var7 = var2.getBase();
    int var8 = var2.getBase();
    int var9 = var2.getAltezza();
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var3 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var4 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var5 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var6 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var7 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var8 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var9 == 1);

  }

  public void test29() throws Throwable {

    if (debug) System.out.printf("%nRandoopTest0.test29");


    esercizio0.Rettangolo var2 = new esercizio0.Rettangolo(100, (-1));
    int var3 = var2.getAltezza();
    int var4 = var2.getAltezza();
    int var5 = var2.getAltezza();
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var3 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var4 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var5 == (-1));

  }

  public void test30() throws Throwable {

    if (debug) System.out.printf("%nRandoopTest0.test30");


    esercizio0.Rettangolo var2 = new esercizio0.Rettangolo(1, 100);
    int var3 = var2.getAltezza();
    int var4 = var2.getBase();
    int var5 = var2.getAltezza();
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var3 == 100);
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var4 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var5 == 100);

  }

  public void test31() throws Throwable {

    if (debug) System.out.printf("%nRandoopTest0.test31");


    esercizio0.Rettangolo var2 = new esercizio0.Rettangolo((-1), 1);
    int var3 = var2.getBase();
    int var4 = var2.getBase();
    int var5 = var2.getBase();
    int var6 = var2.getAltezza();
    int var7 = var2.getBase();
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var3 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var4 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var5 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var6 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var7 == (-1));

  }

  public void test32() throws Throwable {

    if (debug) System.out.printf("%nRandoopTest0.test32");


    esercizio0.Rettangolo var2 = new esercizio0.Rettangolo(0, 1);
    int var3 = var2.getBase();
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var3 == 0);

  }

  public void test33() throws Throwable {

    if (debug) System.out.printf("%nRandoopTest0.test33");


    esercizio0.Rettangolo var2 = new esercizio0.Rettangolo((-1), 1);
    int var3 = var2.getBase();
    int var4 = var2.getBase();
    int var5 = var2.getAltezza();
    int var6 = var2.getBase();
    int var7 = var2.getBase();
    int var8 = var2.getBase();
    int var9 = var2.getBase();
    int var10 = var2.getBase();
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var3 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var4 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var5 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var6 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var7 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var8 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var9 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var10 == (-1));

  }

  public void test34() throws Throwable {

    if (debug) System.out.printf("%nRandoopTest0.test34");


    esercizio0.Rettangolo var2 = new esercizio0.Rettangolo(1, 0);

  }

  public void test35() throws Throwable {

    if (debug) System.out.printf("%nRandoopTest0.test35");


    esercizio0.Rettangolo var2 = new esercizio0.Rettangolo(0, 0);
    int var3 = var2.getAltezza();
    int var4 = var2.getBase();
    int var5 = var2.getBase();
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var4 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var5 == 0);

  }

  public void test36() throws Throwable {

    if (debug) System.out.printf("%nRandoopTest0.test36");


    esercizio0.Rettangolo var2 = new esercizio0.Rettangolo((-1), 1);
    int var3 = var2.getBase();
    int var4 = var2.getBase();
    int var5 = var2.getBase();
    int var6 = var2.getAltezza();
    int var7 = var2.getAltezza();
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var3 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var4 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var5 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var6 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var7 == 1);

  }

  public void test37() throws Throwable {

    if (debug) System.out.printf("%nRandoopTest0.test37");


    esercizio0.Rettangolo var2 = new esercizio0.Rettangolo((-1), 1);
    int var3 = var2.getBase();
    int var4 = var2.getBase();
    int var5 = var2.getBase();
    int var6 = var2.getBase();
    int var7 = var2.getAltezza();
    int var8 = var2.getAltezza();
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var3 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var4 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var5 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var6 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var7 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var8 == 1);

  }

  public void test38() throws Throwable {

    if (debug) System.out.printf("%nRandoopTest0.test38");


    esercizio0.Rettangolo var2 = new esercizio0.Rettangolo((-1), 100);
    int var3 = var2.getBase();
    int var4 = var2.getAltezza();
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var3 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var4 == 100);

  }

  public void test39() throws Throwable {

    if (debug) System.out.printf("%nRandoopTest0.test39");


    esercizio0.Rettangolo var2 = new esercizio0.Rettangolo((-1), 1);
    int var3 = var2.getBase();
    int var4 = var2.getBase();
    int var5 = var2.getBase();
    int var6 = var2.getBase();
    int var7 = var2.getAltezza();
    int var8 = var2.getBase();
    int var9 = var2.getBase();
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var3 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var4 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var5 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var6 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var7 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var8 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var9 == (-1));

  }

  public void test40() throws Throwable {

    if (debug) System.out.printf("%nRandoopTest0.test40");


    esercizio0.Rettangolo var2 = new esercizio0.Rettangolo((-1), 1);
    int var3 = var2.getBase();
    int var4 = var2.getBase();
    int var5 = var2.getAltezza();
    int var6 = var2.getAltezza();
    int var7 = var2.getAltezza();
    int var8 = var2.getAltezza();
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var3 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var4 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var5 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var6 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var7 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var8 == 1);

  }

  public void test41() throws Throwable {

    if (debug) System.out.printf("%nRandoopTest0.test41");


    esercizio0.Rettangolo var2 = new esercizio0.Rettangolo((-1), 10);

  }

  public void test42() throws Throwable {

    if (debug) System.out.printf("%nRandoopTest0.test42");


    esercizio0.Rettangolo var2 = new esercizio0.Rettangolo((-1), 1);
    int var3 = var2.getBase();
    int var4 = var2.getBase();
    int var5 = var2.getBase();
    int var6 = var2.getBase();
    int var7 = var2.getAltezza();
    int var8 = var2.getBase();
    int var9 = var2.getAltezza();
    int var10 = var2.getAltezza();
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var3 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var4 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var5 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var6 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var7 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var8 == (-1));
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var9 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var10 == 1);

  }

  public void test43() throws Throwable {

    if (debug) System.out.printf("%nRandoopTest0.test43");


    esercizio0.Rettangolo var2 = new esercizio0.Rettangolo(100, 10);
    int var3 = var2.getAltezza();
    
    // Regression assertion (captures the current behavior of the code)
    assertTrue(var3 == 10);

  }

}