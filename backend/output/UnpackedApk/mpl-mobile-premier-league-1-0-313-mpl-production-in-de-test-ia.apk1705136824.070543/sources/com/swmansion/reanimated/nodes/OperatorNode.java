package com.swmansion.reanimated.nodes;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableMap;
import com.google.android.material.resources.TextAppearanceConfig;
import com.razorpay.AnalyticsConstants;
import com.swmansion.reanimated.NodesManager;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import sfs2x.client.requests.game.JoinRoomInvitationRequest;

public class OperatorNode extends Node {
    public static final Operator ACOS = new SingleOperator() {
        public double eval(Double d2) {
            return Math.acos(d2.doubleValue());
        }
    };
    public static final Operator ADD = new ReduceOperator() {
        public double reduce(Double d2, Double d3) {
            return d3.doubleValue() + d2.doubleValue();
        }
    };
    public static final Operator AND = new Operator() {
        public double evaluate(Node[] nodeArr) {
            boolean access$200 = OperatorNode.access$200(nodeArr[0].value());
            for (int i = 1; i < nodeArr.length && access$200; i++) {
                access$200 = access$200 && OperatorNode.access$200(nodeArr[i].value());
            }
            return access$200 ? 1.0d : 0.0d;
        }
    };
    public static final Operator ASIN = new SingleOperator() {
        public double eval(Double d2) {
            return Math.asin(d2.doubleValue());
        }
    };
    public static final Operator ATAN = new SingleOperator() {
        public double eval(Double d2) {
            return Math.atan(d2.doubleValue());
        }
    };
    public static final Operator COS = new SingleOperator() {
        public double eval(Double d2) {
            return Math.cos(d2.doubleValue());
        }
    };
    public static final Operator DEFINED = new Operator() {
        public double evaluate(Node[] nodeArr) {
            Object value = nodeArr[0].value();
            return (value == null || ((value instanceof Double) && ((Double) value).isNaN())) ? 0.0d : 1.0d;
        }
    };
    public static final Operator DIVIDE = new ReduceOperator() {
        public double reduce(Double d2, Double d3) {
            return d2.doubleValue() / d3.doubleValue();
        }
    };
    public static final Operator EQ = new CompOperator() {
        public boolean eval(Double d2, Double d3) {
            boolean z = true;
            if (d2 == null || d3 == null) {
                if (d2 != d3) {
                    z = false;
                }
                return z;
            }
            if (d2.doubleValue() != d3.doubleValue()) {
                z = false;
            }
            return z;
        }
    };
    public static final Operator EXP = new SingleOperator() {
        public double eval(Double d2) {
            return Math.exp(d2.doubleValue());
        }
    };
    public static final Operator GREATER_OR_EQ = new CompOperator() {
        public boolean eval(Double d2, Double d3) {
            return d2.doubleValue() >= d3.doubleValue();
        }
    };
    public static final Operator GREATER_THAN = new CompOperator() {
        public boolean eval(Double d2, Double d3) {
            return (d2 == null || d3 == null || d2.doubleValue() <= d3.doubleValue()) ? false : true;
        }
    };
    public static final Operator LESS_OR_EQ = new CompOperator() {
        public boolean eval(Double d2, Double d3) {
            return d2.doubleValue() <= d3.doubleValue();
        }
    };
    public static final Operator LESS_THAN = new CompOperator() {
        public boolean eval(Double d2, Double d3) {
            return (d2 == null || d3 == null || d2.doubleValue() >= d3.doubleValue()) ? false : true;
        }
    };
    public static final Operator LOG = new SingleOperator() {
        public double eval(Double d2) {
            return Math.log(d2.doubleValue());
        }
    };
    public static final Operator MODULO = new ReduceOperator() {
        public double reduce(Double d2, Double d3) {
            return (d3.doubleValue() + (d2.doubleValue() % d3.doubleValue())) % d3.doubleValue();
        }
    };
    public static final Operator MULTIPLY = new ReduceOperator() {
        public double reduce(Double d2, Double d3) {
            return d3.doubleValue() * d2.doubleValue();
        }
    };
    public static final Operator NEQ = new CompOperator() {
        public boolean eval(Double d2, Double d3) {
            boolean z = true;
            if (d2 == null || d3 == null) {
                if (d2 != d3) {
                    z = false;
                }
                return z;
            }
            if (d2.doubleValue() == d3.doubleValue()) {
                z = false;
            }
            return z;
        }
    };
    public static final Operator NOT = new Operator() {
        public double evaluate(Node[] nodeArr) {
            return OperatorNode.access$200(nodeArr[0].value()) ? 0.0d : 1.0d;
        }
    };
    public static final Operator OR = new Operator() {
        public double evaluate(Node[] nodeArr) {
            boolean access$200 = OperatorNode.access$200(nodeArr[0].value());
            for (int i = 1; i < nodeArr.length && !access$200; i++) {
                access$200 = access$200 || OperatorNode.access$200(nodeArr[i].value());
            }
            return access$200 ? 1.0d : 0.0d;
        }
    };
    public static final Operator POW = new ReduceOperator() {
        public double reduce(Double d2, Double d3) {
            return Math.pow(d2.doubleValue(), d3.doubleValue());
        }
    };
    public static final Operator ROUND = new SingleOperator() {
        public double eval(Double d2) {
            return (double) Math.round(d2.doubleValue());
        }
    };
    public static final Operator SIN = new SingleOperator() {
        public double eval(Double d2) {
            return Math.sin(d2.doubleValue());
        }
    };
    public static final Operator SQRT = new SingleOperator() {
        public double eval(Double d2) {
            return Math.sqrt(d2.doubleValue());
        }
    };
    public static final Operator SUB = new ReduceOperator() {
        public double reduce(Double d2, Double d3) {
            return d2.doubleValue() - d3.doubleValue();
        }
    };
    public static final Operator TAN = new SingleOperator() {
        public double eval(Double d2) {
            return Math.tan(d2.doubleValue());
        }
    };
    public final int[] mInputIDs;
    public final Node[] mInputNodes;
    public final Operator mOperator;

    public static abstract class CompOperator implements Operator {
        public CompOperator(AnonymousClass1 r1) {
        }

        public abstract boolean eval(Double d2, Double d3);

        public double evaluate(Node[] nodeArr) {
            return eval((Double) nodeArr[0].value(), (Double) nodeArr[1].value()) ? 1.0d : 0.0d;
        }
    }

    public interface Operator {
        double evaluate(Node[] nodeArr);
    }

    public static abstract class ReduceOperator implements Operator {
        public ReduceOperator(AnonymousClass1 r1) {
        }

        public double evaluate(Node[] nodeArr) {
            double doubleValue = nodeArr[0].doubleValue().doubleValue();
            for (int i = 1; i < nodeArr.length; i++) {
                doubleValue = reduce(Double.valueOf(doubleValue), nodeArr[i].doubleValue());
            }
            return doubleValue;
        }

        public abstract double reduce(Double d2, Double d3);
    }

    public static abstract class SingleOperator implements Operator {
        public SingleOperator(AnonymousClass1 r1) {
        }

        public abstract double eval(Double d2);

        public double evaluate(Node[] nodeArr) {
            return eval((Double) nodeArr[0].value());
        }
    }

    public OperatorNode(int i, ReadableMap readableMap, NodesManager nodesManager) {
        super(i, readableMap, nodesManager);
        int[] processIntArray = TextAppearanceConfig.processIntArray(readableMap.getArray("input"));
        this.mInputIDs = processIntArray;
        this.mInputNodes = new Node[processIntArray.length];
        String string = readableMap.getString(JoinRoomInvitationRequest.KEY_OPTIONAL_PARAMS);
        if ("add".equals(string)) {
            this.mOperator = ADD;
        } else if ("sub".equals(string)) {
            this.mOperator = SUB;
        } else if ("multiply".equals(string)) {
            this.mOperator = MULTIPLY;
        } else if ("divide".equals(string)) {
            this.mOperator = DIVIDE;
        } else if ("pow".equals(string)) {
            this.mOperator = POW;
        } else if ("modulo".equals(string)) {
            this.mOperator = MODULO;
        } else if ("sqrt".equals(string)) {
            this.mOperator = SQRT;
        } else if (AnalyticsConstants.LOG.equals(string)) {
            this.mOperator = LOG;
        } else if ("sin".equals(string)) {
            this.mOperator = SIN;
        } else if ("cos".equals(string)) {
            this.mOperator = COS;
        } else if ("tan".equals(string)) {
            this.mOperator = TAN;
        } else if ("acos".equals(string)) {
            this.mOperator = ACOS;
        } else if ("asin".equals(string)) {
            this.mOperator = ASIN;
        } else if ("atan".equals(string)) {
            this.mOperator = ATAN;
        } else if ("exp".equals(string)) {
            this.mOperator = EXP;
        } else if ("round".equals(string)) {
            this.mOperator = ROUND;
        } else if ("and".equals(string)) {
            this.mOperator = AND;
        } else if ("or".equals(string)) {
            this.mOperator = OR;
        } else if (HSLCriteriaBuilder.NOT.equals(string)) {
            this.mOperator = NOT;
        } else if ("defined".equals(string)) {
            this.mOperator = DEFINED;
        } else if ("lessThan".equals(string)) {
            this.mOperator = LESS_THAN;
        } else if ("eq".equals(string)) {
            this.mOperator = EQ;
        } else if ("greaterThan".equals(string)) {
            this.mOperator = GREATER_THAN;
        } else if ("lessOrEq".equals(string)) {
            this.mOperator = LESS_OR_EQ;
        } else if ("greaterOrEq".equals(string)) {
            this.mOperator = GREATER_OR_EQ;
        } else if ("neq".equals(string)) {
            this.mOperator = NEQ;
        } else {
            throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline50("Unrecognized operator ", string));
        }
    }

    public static boolean access$200(Object obj) {
        return obj != null && !obj.equals(Double.valueOf(0.0d));
    }

    public Object evaluate() {
        int i = 0;
        while (true) {
            int[] iArr = this.mInputIDs;
            if (i >= iArr.length) {
                return Double.valueOf(this.mOperator.evaluate(this.mInputNodes));
            }
            this.mInputNodes[i] = this.mNodesManager.findNodeById(iArr[i], Node.class);
            i++;
        }
    }
}
