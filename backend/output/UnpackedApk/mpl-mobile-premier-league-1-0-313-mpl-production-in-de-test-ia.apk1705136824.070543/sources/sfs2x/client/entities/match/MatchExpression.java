package sfs2x.client.entities.match;

import com.smartfoxserver.v2.entities.data.ISFSArray;
import com.smartfoxserver.v2.entities.data.SFSArray;
import org.apache.fontbox.cmap.CMap;

public class MatchExpression {
    public IMatcher condition;
    public LogicOperator logicOp;
    public MatchExpression next;
    public MatchExpression parent;
    public Object value;
    public String varName;

    public MatchExpression(String str, IMatcher iMatcher, Object obj, LogicOperator logicOperator, MatchExpression matchExpression) {
        this(str, iMatcher, obj);
        this.logicOp = logicOperator;
        this.parent = matchExpression;
    }

    private ISFSArray expressionAsSFSArray() {
        SFSArray sFSArray = new SFSArray();
        LogicOperator logicOperator = this.logicOp;
        if (logicOperator != null) {
            sFSArray.addUtfString(logicOperator.getId());
        } else {
            sFSArray.addNull();
        }
        sFSArray.addUtfString(this.varName);
        sFSArray.addByte((byte) this.condition.getType());
        sFSArray.addUtfString(this.condition.getSymbol());
        if (this.condition.getType() == 0) {
            sFSArray.addBool(((Boolean) this.value).booleanValue());
        } else if (this.condition.getType() == 1) {
            Object obj = this.value;
            if (obj instanceof Integer) {
                sFSArray.addDouble(((Integer) obj).doubleValue());
            } else if (obj instanceof Double) {
                sFSArray.addDouble(((Double) obj).doubleValue());
            } else {
                sFSArray.addDouble(((Double) obj).doubleValue());
            }
        } else {
            sFSArray.addUtfString(this.value.toString());
        }
        return sFSArray;
    }

    public MatchExpression and(String str, IMatcher iMatcher, Object obj) {
        MatchExpression matchExpression = new MatchExpression(str, iMatcher, obj, LogicOperator.AND, this);
        this.next = matchExpression;
        return matchExpression;
    }

    public String asString() {
        StringBuilder sb = new StringBuilder();
        if (this.logicOp != null) {
            sb.append(CMap.SPACE);
            sb.append(this.logicOp.getId());
            sb.append(CMap.SPACE);
        }
        sb.append("(");
        sb.append(this.varName);
        sb.append(CMap.SPACE);
        sb.append(this.condition.getSymbol());
        sb.append(CMap.SPACE);
        Object obj = this.value;
        if (obj instanceof String) {
            obj = "'" + this.value + "'";
        }
        sb.append(obj);
        sb.append(")");
        return sb.toString();
    }

    public IMatcher getCondition() {
        return this.condition;
    }

    public LogicOperator getLogicOp() {
        return this.logicOp;
    }

    public MatchExpression getNext() {
        return this.next;
    }

    public Object getValue() {
        return this.value;
    }

    public String getVarName() {
        return this.varName;
    }

    public boolean hasNext() {
        return this.next != null;
    }

    public MatchExpression or(String str, IMatcher iMatcher, Object obj) {
        MatchExpression matchExpression = new MatchExpression(str, iMatcher, obj, LogicOperator.OR, this);
        this.next = matchExpression;
        return matchExpression;
    }

    public MatchExpression rewind() {
        MatchExpression matchExpression = this;
        while (true) {
            MatchExpression matchExpression2 = matchExpression.parent;
            if (matchExpression2 == null) {
                return matchExpression;
            }
            matchExpression = matchExpression2;
        }
    }

    public ISFSArray toSFSArray() {
        MatchExpression rewind = rewind();
        SFSArray sFSArray = new SFSArray();
        sFSArray.addSFSArray(rewind.expressionAsSFSArray());
        while (rewind.hasNext()) {
            rewind = rewind.next;
            sFSArray.addSFSArray(rewind.expressionAsSFSArray());
        }
        return sFSArray;
    }

    public String toString() {
        MatchExpression rewind = rewind();
        StringBuilder sb = new StringBuilder(rewind.asString());
        while (rewind.hasNext()) {
            rewind = rewind.next;
            sb.append(rewind.asString());
        }
        return sb.toString();
    }

    public MatchExpression(String str, IMatcher iMatcher, Object obj) {
        this.varName = str;
        this.condition = iMatcher;
        this.value = obj;
    }
}
