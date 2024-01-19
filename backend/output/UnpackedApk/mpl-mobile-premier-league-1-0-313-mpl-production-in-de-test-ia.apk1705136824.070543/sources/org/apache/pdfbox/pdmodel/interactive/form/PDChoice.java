package org.apache.pdfbox.pdmodel.interactive.form;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.pdmodel.common.COSArrayList;
import org.apache.pdfbox.pdmodel.interactive.form.FieldUtils.KeyValue;

public abstract class PDChoice extends PDVariableText {
    public static final int FLAG_COMBO = 131072;
    public static final int FLAG_COMMIT_ON_SEL_CHANGE = 67108864;
    public static final int FLAG_DO_NOT_SPELL_CHECK = 4194304;
    public static final int FLAG_MULTI_SELECT = 2097152;
    public static final int FLAG_SORT = 524288;

    public PDChoice(PDAcroForm pDAcroForm) {
        super(pDAcroForm);
        getDictionary().setItem(COSName.FT, (COSBase) COSName.CH);
    }

    private void updateSelectedOptionsIndex(List<String> list) {
        List<String> options = getOptions();
        ArrayList arrayList = new ArrayList();
        for (String indexOf : list) {
            arrayList.add(Integer.valueOf(options.indexOf(indexOf)));
        }
        Collections.sort(arrayList);
        setSelectedOptionsIndex(arrayList);
    }

    public List<String> getOptions() {
        return FieldUtils.getPairableItems(getDictionary().getDictionaryObject(COSName.OPT), 0);
    }

    public List<String> getOptionsDisplayValues() {
        return FieldUtils.getPairableItems(getDictionary().getDictionaryObject(COSName.OPT), 0);
    }

    public List<String> getOptionsExportValues() {
        return getOptions();
    }

    public List<Integer> getSelectedOptionsIndex() {
        COSBase dictionaryObject = getDictionary().getDictionaryObject(COSName.I);
        if (dictionaryObject != null) {
            return COSArrayList.convertIntegerCOSArrayToList((COSArray) dictionaryObject);
        }
        return Collections.emptyList();
    }

    public boolean isCombo() {
        return getDictionary().getFlag(COSName.FF, 131072);
    }

    public boolean isCommitOnSelChange() {
        return getDictionary().getFlag(COSName.FF, FLAG_COMMIT_ON_SEL_CHANGE);
    }

    public boolean isDoNotSpellCheck() {
        return getDictionary().getFlag(COSName.FF, 4194304);
    }

    public boolean isMultiSelect() {
        return getDictionary().getFlag(COSName.FF, FLAG_MULTI_SELECT);
    }

    public boolean isSort() {
        return getDictionary().getFlag(COSName.FF, 524288);
    }

    public void setCombo(boolean z) {
        getDictionary().setFlag(COSName.FF, 131072, z);
    }

    public void setCommitOnSelChange(boolean z) {
        getDictionary().setFlag(COSName.FF, FLAG_COMMIT_ON_SEL_CHANGE, z);
    }

    public void setDefaultValue(String str) {
        if (str == null) {
            getDictionary().removeItem(COSName.DV);
        } else if (getOptions().indexOf(str) != -1) {
            getDictionary().setString(COSName.DV, str);
        } else {
            throw new IllegalArgumentException("The list box does not contain the given value.");
        }
    }

    public void setDoNotSpellCheck(boolean z) {
        getDictionary().setFlag(COSName.FF, 4194304, z);
    }

    public void setMultiSelect(boolean z) {
        getDictionary().setFlag(COSName.FF, FLAG_MULTI_SELECT, z);
    }

    public void setOptions(List<String> list) {
        if (list == null || list.isEmpty()) {
            getDictionary().removeItem(COSName.OPT);
            return;
        }
        if (isSort()) {
            Collections.sort(list);
        }
        getDictionary().setItem(COSName.OPT, (COSBase) COSArrayList.convertStringListToCOSStringCOSArray(list));
    }

    public void setSelectedOptionsIndex(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            getDictionary().removeItem(COSName.I);
        } else if (isMultiSelect()) {
            getDictionary().setItem(COSName.I, (COSBase) COSArrayList.converterToCOSArray(list));
        } else {
            throw new IllegalArgumentException("Setting the indices is not allowed for choice fields not allowing multiple selections.");
        }
    }

    public void setSort(boolean z) {
        getDictionary().setFlag(COSName.FF, 524288, z);
    }

    public void setValue(String str) {
        if (str == null) {
            getDictionary().removeItem(COSName.V);
        } else if (getOptions().indexOf(str) != -1) {
            getDictionary().setString(COSName.V, str);
            setSelectedOptionsIndex(null);
        } else {
            throw new IllegalArgumentException("The list box does not contain the given value.");
        }
    }

    public String getDefaultValue() {
        return ((COSString) getInheritableAttribute(COSName.DV)).getString();
    }

    public List<String> getValue() {
        COSBase dictionaryObject = getDictionary().getDictionaryObject(COSName.V);
        if (dictionaryObject instanceof COSString) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(((COSString) dictionaryObject).getString());
            return arrayList;
        } else if (dictionaryObject instanceof COSArray) {
            return COSArrayList.convertCOSStringCOSArrayToList((COSArray) dictionaryObject);
        } else {
            return Collections.emptyList();
        }
    }

    public PDChoice(PDAcroForm pDAcroForm, COSDictionary cOSDictionary, PDFieldTreeNode pDFieldTreeNode) {
        super(pDAcroForm, cOSDictionary, pDFieldTreeNode);
    }

    public void setOptions(List<String> list, List<String> list2) {
        if (list == null || list2 == null || list.isEmpty() || list2.isEmpty()) {
            getDictionary().removeItem(COSName.OPT);
        } else if (list.size() == list2.size()) {
            List<KeyValue> keyValueList = FieldUtils.toKeyValueList(list, list2);
            if (isSort()) {
                FieldUtils.sortByValue(keyValueList);
            }
            COSArray cOSArray = new COSArray();
            for (int i = 0; i < list.size(); i++) {
                COSArray cOSArray2 = new COSArray();
                cOSArray2.add((COSBase) new COSString(keyValueList.get(i).getKey()));
                cOSArray2.add((COSBase) new COSString(keyValueList.get(i).getValue()));
                cOSArray.add((COSBase) cOSArray2);
            }
            getDictionary().setItem(COSName.OPT, (COSBase) cOSArray);
        } else {
            throw new IllegalArgumentException("The number of entries for exportValue and displayValue shall be the same.");
        }
    }

    public void setValue(List<String> list) {
        if (list == null || list.isEmpty()) {
            getDictionary().removeItem(COSName.V);
        } else if (!isMultiSelect()) {
            throw new IllegalArgumentException("The list box does not allow multiple selections.");
        } else if (getOptions().containsAll(list)) {
            getDictionary().setItem(COSName.V, (COSBase) COSArrayList.convertStringListToCOSStringCOSArray(list));
            updateSelectedOptionsIndex(list);
        } else {
            throw new IllegalArgumentException("The values are not contained in the selectable options.");
        }
    }
}
