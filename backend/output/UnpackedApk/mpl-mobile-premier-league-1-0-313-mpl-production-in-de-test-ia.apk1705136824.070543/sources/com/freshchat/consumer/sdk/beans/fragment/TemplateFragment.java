package com.freshchat.consumer.sdk.beans.fragment;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.freshchat.consumer.sdk.j.ab.c;
import com.freshchat.consumer.sdk.j.k;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.text.ExtendedMessageFormat;

public abstract class TemplateFragment extends MessageFragment {
    @c
    public final HashMap<SectionKey, List<MessageFragment>> sectionMap = new HashMap<>();
    public List<Section> sections;
    public final String templateType;

    public static class Section {
        public List<MessageFragment> fragments;
        @SerializedName("name")
        public SectionKey sectionKey;

        public List<MessageFragment> getFragments() {
            return this.fragments;
        }

        public SectionKey getSectionKey() {
            return this.sectionKey;
        }

        public void setFragments(List<MessageFragment> list) {
            this.fragments = list;
        }

        public void setSectionKey(SectionKey sectionKey2) {
            this.sectionKey = sectionKey2;
        }

        public String toString() {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Section{sectionKey='");
            outline73.append(this.sectionKey);
            outline73.append(ExtendedMessageFormat.QUOTE);
            outline73.append(", fragments=");
            outline73.append(this.fragments);
            outline73.append('}');
            return outline73.toString();
        }
    }

    public TemplateFragment(String str) {
        super(FragmentType.TEMPLATE.asInt());
        this.templateType = str;
    }

    public List<MessageFragment> getFragmentsForSection(SectionKey sectionKey) {
        if (k.isEmpty(this.sections)) {
            return null;
        }
        if (k.c((Map<?, ?>) this.sectionMap)) {
            for (Section next : this.sections) {
                this.sectionMap.put(next.getSectionKey(), next.fragments);
            }
        }
        return this.sectionMap.get(sectionKey);
    }

    public List<Section> getSections() {
        return this.sections;
    }

    public MessageFragment getSingleFragmentFromSection(SectionKey sectionKey) {
        List<MessageFragment> fragmentsForSection = getFragmentsForSection(sectionKey);
        if (k.a(fragmentsForSection)) {
            return fragmentsForSection.get(0);
        }
        return null;
    }

    public String getTemplateType() {
        return this.templateType;
    }

    public void replaceSection(SectionKey sectionKey, List<MessageFragment> list) {
        if (!k.isEmpty(this.sections)) {
            this.sectionMap.clear();
            Section section = null;
            Iterator<Section> it = this.sections.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Section next = it.next();
                if (next.getSectionKey() == sectionKey) {
                    section = next;
                    break;
                }
            }
            if (section != null) {
                this.sections.remove(section);
            }
            Section section2 = new Section();
            section2.setSectionKey(sectionKey);
            section2.setFragments(list);
            this.sections.add(section2);
        }
    }

    public void setSections(List<Section> list) {
        this.sections = list;
        this.sectionMap.clear();
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("TemplateFragment{messageFragment='");
        GeneratedOutlineSupport.outline99(outline73, super.toString(), ExtendedMessageFormat.QUOTE, ", templateType='");
        GeneratedOutlineSupport.outline99(outline73, this.templateType, ExtendedMessageFormat.QUOTE, ", sections=");
        outline73.append(this.sections);
        outline73.append(", sectionMap=");
        outline73.append(this.sectionMap);
        outline73.append('}');
        return outline73.toString();
    }
}
