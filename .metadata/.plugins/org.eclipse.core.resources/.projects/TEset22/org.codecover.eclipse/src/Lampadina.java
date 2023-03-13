
public class Lampadina {
  static {
    CodeCoverCoverageCounter$37w3oryc3968etcs751ish.ping();
  }

	
	{ CodeCoverCoverageCounter$37w3oryc3968etcs751ish.statements[1]++; }
boolean accesa = false;
	
	// setta il voltaggio, accende o spegne la lampadina
	// restituisce true se lo stato cambia
	boolean setVoltes(float volt) {
int CodeCoverConditionCoverageHelper_C1;
		CodeCoverCoverageCounter$37w3oryc3968etcs751ish.statements[2]++;
if((((((CodeCoverConditionCoverageHelper_C1 = 0) == 0) || true) && (!
(((CodeCoverConditionCoverageHelper_C1 |= (32)) == 0 || true) &&
 ((accesa) && 
  ((CodeCoverConditionCoverageHelper_C1 |= (16)) == 0 || true)))
 && (
(((CodeCoverConditionCoverageHelper_C1 |= (8)) == 0 || true) &&
 ((volt <= 13) && 
  ((CodeCoverConditionCoverageHelper_C1 |= (4)) == 0 || true)))
 || 
(((CodeCoverConditionCoverageHelper_C1 |= (2)) == 0 || true) &&
 ((volt >= 11) && 
  ((CodeCoverConditionCoverageHelper_C1 |= (1)) == 0 || true)))
))) && (CodeCoverCoverageCounter$37w3oryc3968etcs751ish.conditionCounters[1].incrementCounterOfBitMask(CodeCoverConditionCoverageHelper_C1, 3) || true)) || (CodeCoverCoverageCounter$37w3oryc3968etcs751ish.conditionCounters[1].incrementCounterOfBitMask(CodeCoverConditionCoverageHelper_C1, 3) && false)) {
CodeCoverCoverageCounter$37w3oryc3968etcs751ish.branches[1]++;
			CodeCoverCoverageCounter$37w3oryc3968etcs751ish.statements[3]++;
accesa = true;
			CodeCoverCoverageCounter$37w3oryc3968etcs751ish.statements[4]++;
return true;

		} else {
  CodeCoverCoverageCounter$37w3oryc3968etcs751ish.branches[2]++;}
int CodeCoverConditionCoverageHelper_C2;
		CodeCoverCoverageCounter$37w3oryc3968etcs751ish.statements[5]++;
if((((((CodeCoverConditionCoverageHelper_C2 = 0) == 0) || true) && (
(((CodeCoverConditionCoverageHelper_C2 |= (8)) == 0 || true) &&
 ((accesa) && 
  ((CodeCoverConditionCoverageHelper_C2 |= (4)) == 0 || true)))
 && 
(((CodeCoverConditionCoverageHelper_C2 |= (2)) == 0 || true) &&
 ((volt <= 2) && 
  ((CodeCoverConditionCoverageHelper_C2 |= (1)) == 0 || true)))
)) && (CodeCoverCoverageCounter$37w3oryc3968etcs751ish.conditionCounters[2].incrementCounterOfBitMask(CodeCoverConditionCoverageHelper_C2, 2) || true)) || (CodeCoverCoverageCounter$37w3oryc3968etcs751ish.conditionCounters[2].incrementCounterOfBitMask(CodeCoverConditionCoverageHelper_C2, 2) && false)) {
CodeCoverCoverageCounter$37w3oryc3968etcs751ish.branches[3]++;
			CodeCoverCoverageCounter$37w3oryc3968etcs751ish.statements[6]++;
accesa = false;
			CodeCoverCoverageCounter$37w3oryc3968etcs751ish.statements[7]++;
return true;

		} else {
  CodeCoverCoverageCounter$37w3oryc3968etcs751ish.branches[4]++;}
		CodeCoverCoverageCounter$37w3oryc3968etcs751ish.statements[8]++;
return false;
	}

}

class CodeCoverCoverageCounter$37w3oryc3968etcs751ish extends org.codecover.instrumentation.java.measurement.CounterContainer {

  static {
    org.codecover.instrumentation.java.measurement.ProtocolImpl.getInstance(org.codecover.instrumentation.java.measurement.CoverageResultLogFile.getInstance("C:\\Users\\isaac\\workspace-testing2023\\.metadata\\.plugins\\org.eclipse.core.resources\\.projects\\TEset22\\org.codecover.eclipse\\coverage-logs\\coverage-log-file.clf"), "937aeb56-8c82-40b2-a631-a1cd9e28c615").addObservedContainer(new CodeCoverCoverageCounter$37w3oryc3968etcs751ish ());
  }
    public static long[] statements = new long[9];
    public static long[] branches = new long[5];

  public static final org.codecover.instrumentation.java.measurement.ConditionCounter[] conditionCounters = new org.codecover.instrumentation.java.measurement.ConditionCounter[3];
  static {
    final String SECTION_NAME = "Lampadina.java";
    final byte[] CONDITION_COUNTER_TYPES = {0,3,2};
    for (int i = 1; i <= 2; i++) {
      switch (CONDITION_COUNTER_TYPES[i]) {
        case 0 : break;
        case 1 : conditionCounters[i] = new org.codecover.instrumentation.java.measurement.SmallOneConditionCounter(SECTION_NAME, "C" + i); break;
        case 2 : conditionCounters[i] = new org.codecover.instrumentation.java.measurement.SmallTwoConditionCounter(SECTION_NAME, "C" + i); break;
        case 3 : conditionCounters[i] = new org.codecover.instrumentation.java.measurement.MediumConditionCounter(SECTION_NAME, "C" + i); break;
        case 4 : conditionCounters[i] = new org.codecover.instrumentation.java.measurement.LargeConditionCounter(SECTION_NAME, "C" + i); break;
      }
    }
  }
    public static long[] loops = new long[1];
    public static java.util.concurrent.atomic.AtomicLong[] syncs = new java.util.concurrent.atomic.AtomicLong[3];
    static {
      for (int i = 0; i <= 2; i++) {
        syncs[i] = new java.util.concurrent.atomic.AtomicLong(0L);
      }
    }
    public static java.util.Hashtable[] syncWaits = new java.util.Hashtable[1];
    static {
      for (int i = 0; i <= 0; i++) {
        syncWaits[i] = new java.util.Hashtable();
      }
    }
    public static long[] qmo = new long[2];

  public CodeCoverCoverageCounter$37w3oryc3968etcs751ish () {
    super("Lampadina.java");
  }

  public static void ping() {/* nothing to do*/}

  public void reset() {
      for (int i = 1; i <= 8; i++) {
        statements[i] = 0L;
      }
      for (int i = 1; i <= 4; i++) {
        branches[i] = 0L;
      }
    for (int i = 1; i <= 2; i++) {
      if (conditionCounters[i] != null) {
        conditionCounters[i].reset();
      }
    }
      for (int i = 1; i <= 0; i++) {
        loops[i] = 0L;
      }
      for (int i = 0; i <= 2; i++) {
        syncs[i].set(0L);
      }
      for (int i = 0; i < 2; i++) {
        qmo[i] = 0L;
      }
  }

  public void serializeAndReset(org.codecover.instrumentation.measurement.CoverageCounterLog log) {
    log.startNamedSection("Lampadina.java");
      for (int i = 1; i <= 8; i++) {
        if (statements[i] != 0L) {
          log.passCounter("S" + i, statements[i]);
          statements[i] = 0L;
        }
      }
      for (int i = 1; i <= 4; i++) {
        if (branches[i] != 0L) {
          log.passCounter("B"+ i, branches[i]);
          branches[i] = 0L;
        }
      }
    for (int i = 1; i <= 2; i++) {
      if (conditionCounters[i] != null) {
        conditionCounters[i].serializeAndReset(log);
      }
    }
      for (int i = 1; i <= 0; i++) {
        if (loops[i * 3 - 2] != 0L) {
          log.passCounter("L" + i + "-0", loops[i * 3 - 2]);
          loops[i * 3 - 2] = 0L;
        }
        if ( loops[i * 3 - 1] != 0L) {
          log.passCounter("L" + i + "-1", loops[i * 3 - 1]);
          loops[i * 3 - 1] = 0L;
        }
        if ( loops[i * 3] != 0L) {
          log.passCounter("L" + i + "-2", loops[i * 3]);
          loops[i * 3] = 0L;
        }
      }
      for (int i = 0; i <= 0; i++) {
        if (syncs[i * 3].get() != 0L) {
          log.passCounter("Y" + i + "-0", syncs[i * 3].get());
          syncs[i * 3].set(0L);
        }
        if (syncs[i * 3 + 1].get() != 0L) {
          log.passCounter("Y" + i + "-1", syncs[i * 3 + 1].get());
          syncs[i * 3 + 1].set(0L);
        }
        if (syncs[i * 3 + 2].get() != 0L) {
          log.passCounter("Y" + i + "-2", syncs[i * 3 + 2].get());
          syncs[i * 3 + 2].set(0L);
        }
      }
      for (int i = 0; i < 1; i++) {
        if (qmo[i * 2] != 0L) {
          log.passCounter("Q" + i + "-0", qmo[i * 2]);
          qmo[i * 2] = 0L;
        }
        if (qmo[i * 2 + 1] != 0L) {
          log.passCounter("Q" + i + "-1", qmo[i * 2 + 1]);
          qmo[i * 2 + 1] = 0L;
        }
      }
  }
}

