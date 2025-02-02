package com.habitrpg.android.habitica.ui.adapter.tasks

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.internal.ViewUtils.getContentView
import com.habitrpg.android.habitica.helpers.TaskFilterHelper
import com.habitrpg.android.habitica.ui.viewHolders.tasks.DailyViewHolder

class DailiesRecyclerViewHolder(layoutResource: Int, taskFilterHelper: TaskFilterHelper) : RealmBaseTasksRecyclerViewAdapter(layoutResource, taskFilterHelper) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == 0) {
            DailyViewHolder(
                getContentView(parent), { task, direction -> taskScoreEventsSubject.onNext(Pair(task, direction)) },
                { task, item -> checklistItemScoreSubject.onNext(Pair(task, item)) },
                {
                        task ->
                    taskOpenEventsSubject.onNext(task)
                }
            ) {
                    task ->
                brokenTaskEventsSubject.onNext(task)
            }
        } else {
            super.onCreateViewHolder(parent, viewType)
        }
    }
}
