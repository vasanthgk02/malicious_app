package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import java.util.List;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirement;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable;

/* compiled from: VersionRequirement.kt */
public final class VersionRequirementTable {
    public static final Companion Companion = new Companion(null);
    public static final VersionRequirementTable EMPTY = new VersionRequirementTable(EmptyList.INSTANCE);
    public final List<ProtoBuf$VersionRequirement> infos;

    /* compiled from: VersionRequirement.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final VersionRequirementTable create(ProtoBuf$VersionRequirementTable protoBuf$VersionRequirementTable) {
            Intrinsics.checkNotNullParameter(protoBuf$VersionRequirementTable, "table");
            if (protoBuf$VersionRequirementTable.requirement_.size() == 0) {
                return VersionRequirementTable.EMPTY;
            }
            List<ProtoBuf$VersionRequirement> list = protoBuf$VersionRequirementTable.requirement_;
            Intrinsics.checkNotNullExpressionValue(list, "table.requirementList");
            return new VersionRequirementTable(list, null);
        }
    }

    public VersionRequirementTable(List<ProtoBuf$VersionRequirement> list) {
        this.infos = list;
    }

    public VersionRequirementTable(List list, DefaultConstructorMarker defaultConstructorMarker) {
        this.infos = list;
    }
}
